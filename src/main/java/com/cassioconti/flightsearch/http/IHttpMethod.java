package com.cassioconti.flightsearch.http;

import java.io.IOException;

public interface IHttpMethod {
    String doPost(String jsonContent) throws IOException;
}
