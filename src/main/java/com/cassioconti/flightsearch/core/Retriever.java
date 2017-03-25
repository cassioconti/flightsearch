package com.cassioconti.flightsearch.core;

import java.io.IOException;

public class Retriever {
    private final IHttpMethod httpMethod;
    private final IQueryBuilder queryBuilder;

    public Retriever(IHttpMethod httpMethod, IQueryBuilder queryBuilder){
        this.httpMethod = httpMethod;
        this.queryBuilder = queryBuilder;
    }

    public String Retrieve() {
        String query = this.queryBuilder.build();

        try {
            return this.httpMethod.doPost(query);
        } catch (IOException e) {
            return "";
        }
    }
}