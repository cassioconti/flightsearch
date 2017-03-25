package com.cassioconti.flightsearch.core;

import java.io.IOException;

public class Retriever {
    private IHttpMethod httpMethod;
    private IQueryBuilder queryBuilder;

    public Retriever(IHttpMethod httpMethod, IQueryBuilder queryBuilder){
        this.httpMethod = httpMethod;
        this.queryBuilder = queryBuilder;
    }

    public void Retrieve() {
        String query = this.queryBuilder.build();

        try {
            String json = this.httpMethod.doPost(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}