package com.cassioconti.flightsearch.core;

import java.util.ArrayList;
import java.util.List;

public class FlightOption {
    private String saleTotal;
    private ArrayList<Segment> segments;

    public FlightOption(String saleTotal) {
        this.saleTotal = saleTotal;
        this.segments = new ArrayList<>();
    }

    public void addSegment(String origin, String destination, String departureTime, String arrivalTime) {
        Segment segment = new Segment(origin, destination, departureTime, arrivalTime);
        this.segments.add(segment);
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public List<Segment> getSegments() {
        return this.segments;
    }
}
