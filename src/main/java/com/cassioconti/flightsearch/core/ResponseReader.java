package com.cassioconti.flightsearch.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class ResponseReader {
    private double bestPrice;
    private ArrayList<FlightOption> flights;

    public ResponseReader(String responseToRead) {
        this.flights = new ArrayList<>();

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(responseToRead).getAsJsonObject();
        JsonArray tripOptions = jsonObject.getAsJsonObject("trips").getAsJsonArray("tripOption");

        for (int i = 0; i < tripOptions.size(); i++) {
            JsonObject tripOption = tripOptions.get(i).getAsJsonObject();

            String saleTotal = tripOption.get("saleTotal").getAsString();
            FlightOption flightOption = new FlightOption(saleTotal);

            JsonArray slices = tripOption.getAsJsonArray("slice");
            for (int j = 0; j < slices.size(); j++) {
                JsonObject slice = slices.get(j).getAsJsonObject();
                JsonArray segments = slice.getAsJsonArray("segment");
                for (int k = 0; k < segments.size(); k++) {
                    JsonObject segment = segments.get(k).getAsJsonObject();
                    JsonObject leg = segment.getAsJsonArray("leg").get(0).getAsJsonObject();
                    String origin = leg.get("origin").getAsString();
                    String destination = leg.get("destination").getAsString();
                    String departureTime = leg.get("departureTime").getAsString();
                    String arrivalTime = leg.get("arrivalTime").getAsString();

                    flightOption.addSegment(origin, destination, departureTime, arrivalTime);
                }
            }

            this.flights.add(flightOption);

            double thisTripPrice = Double.parseDouble(saleTotal.substring(3));
            if (this.bestPrice > thisTripPrice || i == 0) {
                this.bestPrice = thisTripPrice;
            }
        }
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public List<FlightOption> getFlights() {
        return flights;
    }
}
