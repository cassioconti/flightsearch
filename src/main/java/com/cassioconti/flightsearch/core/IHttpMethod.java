package com.cassioconti.flightsearch.core;

import java.io.IOException;

public interface IHttpMethod {
    String doPost(String jsonContent) throws IOException;
}
