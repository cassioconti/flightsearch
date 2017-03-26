package com.cassioconti.flightsearch.core;

import org.mockito.Mockito;

import java.io.IOException;
import java.util.Scanner;

public class Index {

    public ResponseReader Run(){
        Retriever retriever = new Retriever(new FakeHttpMethod(), new QueryBuilder());
        // Retriever retriever = new Retriever(new HttpMethod(), new QueryBuilder());
        return retriever.Retrieve("FLN", "IAH", "2017-07-07", "2017-07-22", 4, 7200, "US");
    }
}
