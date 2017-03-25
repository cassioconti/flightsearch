package com.cassioconti.flightsearch.core.tests;

import com.cassioconti.flightsearch.core.FlightOption;
import com.cassioconti.flightsearch.core.ResponseReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ResponseReaderTests {
    @Test
    public void TestHappyPath1() {
        String responseExample = new Scanner(ResponseReaderTests.class.getResourceAsStream("/JsonResponseExample1.json")).useDelimiter("\\A").next();

        ResponseReader responseReader = new ResponseReader(responseExample);

        Assert.assertEquals(6877.04, responseReader.getBestPrice(), 1e-10);
        Assert.assertEquals(13, responseReader.getFlights().size());

        Assert.assertEquals(5, responseReader.getFlights().get(0).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(1).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(2).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(3).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(4).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(5).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(6).getSegments().size());
        Assert.assertEquals(4, responseReader.getFlights().get(7).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(8).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(9).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(10).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(11).getSegments().size());
        Assert.assertEquals(5, responseReader.getFlights().get(12).getSegments().size());

        for (int i = 0; i < responseReader.getFlights().size(); i++) {
            FlightOption flightOption = responseReader.getFlights().get(i);
            Assert.assertEquals("FLN", flightOption.getSegments().get(0).getOrigin());
            Assert.assertEquals("FLN", flightOption.getSegments().get(flightOption.getSegments().size() - 1).getDestination());
        }
    }
}