package com.cassioconti.flightsearch.core;

public class Segment {
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    public Segment(String origin, String destination, String departureTime, String arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
}