package com.cassioconti.flightsearch.interpreter.tests;

import com.cassioconti.flightsearch.interpreter.FlightOption;
import com.cassioconti.flightsearch.interpreter.ResponseReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ResponseReaderTest {
    @Test
    public void TestHappyPath1() {
        String responseExample = new Scanner(ResponseReaderTest.class.getResourceAsStream("/JsonResponseExample1.json")).useDelimiter("\\A").next();

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

    @Test
    public void EmptyResult() {
        String emptyReturn = new Scanner(ResponseReader.class.getResourceAsStream("/EmptyContent.txt")).useDelimiter("\\A").next();
        ResponseReader responseReader = new ResponseReader(emptyReturn);
        Assert.assertEquals(0, responseReader.getBestPrice(), 1e-10);
        Assert.assertEquals(0, responseReader.getFlights().size());
    }
}