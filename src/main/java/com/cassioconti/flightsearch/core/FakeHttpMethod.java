package com.cassioconti.flightsearch.core;

import java.io.IOException;
import java.util.Scanner;

public class FakeHttpMethod implements IHttpMethod {
    @Override
    public String doPost(String jsonContent) throws IOException {
        return new Scanner(FakeHttpMethod.class.getResourceAsStream("/JsonResponseExample1.json")).useDelimiter("\\A").next();
    }
}