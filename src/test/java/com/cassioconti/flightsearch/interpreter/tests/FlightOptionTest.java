package com.cassioconti.flightsearch.interpreter.tests;

import com.cassioconti.flightsearch.interpreter.FlightOption;
import org.junit.Assert;
import org.junit.Test;

public class FlightOptionTest {
    @Test
    public void TestHappyPath() {
        String tripPrice = "USD720";
        FlightOption flightOption = new FlightOption("USD720");

        String origin1 = "FLN";
        String destination1 = "IAH";
        String departureTime1 = "2017-07-07T18:35-03:00";
        String arrivalTime1 = "2017-07-07T19:50-03:00";
        flightOption.addSegment(origin1, destination1, departureTime1, arrivalTime1);

        String origin2 = "MGF";
        String destination2 = "HOU";
        String departureTime2 = "2017-07-22T10:00-03:00";
        String arrivalTime2 = "2017-07-23T11:21-03:00";
        flightOption.addSegment(origin2, destination2, departureTime2, arrivalTime2);

        Assert.assertEquals(tripPrice, flightOption.getSaleTotal());
        Assert.assertEquals(2, flightOption.getSegments().size());

        Assert.assertEquals(origin1, flightOption.getSegments().get(0).getOrigin());
        Assert.assertEquals(destination1, flightOption.getSegments().get(0).getDestination());
        Assert.assertEquals(departureTime1, flightOption.getSegments().get(0).getDepartureTime());
        Assert.assertEquals(arrivalTime1, flightOption.getSegments().get(0).getArrivalTime());

        Assert.assertEquals(origin2, flightOption.getSegments().get(1).getOrigin());
        Assert.assertEquals(destination2, flightOption.getSegments().get(1).getDestination());
        Assert.assertEquals(departureTime2, flightOption.getSegments().get(1).getDepartureTime());
        Assert.assertEquals(arrivalTime2, flightOption.getSegments().get(1).getArrivalTime());
    }
}
