package com.cassioconti.flightsearch.core.tests;

import com.cassioconti.flightsearch.core.Segment;
import org.junit.Assert;
import org.junit.Test;

public class SegmentTest {
    @Test
    public void TestHappyPath1() {
        String origin = "FLN";
        String destination = "IAH";
        String departureTime = "2017-07-07T18:35-03:00";
        String arrivalTime = "2017-07-07T19:50-03:00";

        Segment segment = new Segment(origin, destination, departureTime, arrivalTime);

        Assert.assertEquals(origin, segment.getOrigin());
        Assert.assertEquals(destination, segment.getDestination());
        Assert.assertEquals(departureTime, segment.getDepartureTime());
        Assert.assertEquals(arrivalTime, segment.getArrivalTime());
    }

    @Test
    public void TestHappyPath2() {
        String origin = "MGF";
        String destination = "HOU";
        String departureTime = "2017-07-22T10:00-03:00";
        String arrivalTime = "2017-07-23T11:21-03:00";

        Segment segment = new Segment(origin, destination, departureTime, arrivalTime);

        Assert.assertEquals(origin, segment.getOrigin());
        Assert.assertEquals(destination, segment.getDestination());
        Assert.assertEquals(departureTime, segment.getDepartureTime());
        Assert.assertEquals(arrivalTime, segment.getArrivalTime());
    }
}
