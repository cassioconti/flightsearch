package com.cassioconti.flightsearch.core;

import org.mockito.Mockito;

import java.io.IOException;
import java.util.Scanner;

public class Index {

    public ResponseReader Run(){
        IHttpMethod httpMethodMock = Mockito.mock(IHttpMethod.class);
        try {
            String content = new Scanner(Retriever.class.getResourceAsStream("/JsonResponseExample1.json")).useDelimiter("\\A").next();
            Mockito.doReturn(content).when(httpMethodMock).doPost(Mockito.anyString());
        } catch (IOException e) {
            // This code will be removed. For now I do not want to call the real API otherwise I will count on my limited number of queries.
        }

        Retriever retriever = new Retriever(httpMethodMock, new QueryBuilder());
        // Retriever retriever = new Retriever(new HttpMethod(), new QueryBuilder());
        return retriever.Retrieve("FLN", "IAH", "2017-07-07", "2017-07-22", 4, 7200, "US");
    }
}
