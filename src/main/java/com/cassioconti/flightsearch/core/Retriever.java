package com.cassioconti.flightsearch.core;

import java.io.IOException;
import java.util.Scanner;

public class Retriever {
    private final IHttpMethod httpMethod;
    private final IQueryBuilder queryBuilder;

    public Retriever(IHttpMethod httpMethod, IQueryBuilder queryBuilder) {
        this.httpMethod = httpMethod;
        this.queryBuilder = queryBuilder;
    }

    public ResponseReader Retrieve(String from, String to, String startDate, String endDate, int numberOfAdults, int maxPriceUsd, String saleCountry) {
        String query = this.queryBuilder.build(from, to, startDate, endDate, numberOfAdults, maxPriceUsd, saleCountry);
        String content;

        try {
            content = this.httpMethod.doPost(query);
        } catch (IOException e) {
            content = new Scanner(Retriever.class.getResourceAsStream("/EmptyContent.txt")).useDelimiter("\\A").next();
        }

        return new ResponseReader(content);
    }
}