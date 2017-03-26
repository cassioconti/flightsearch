package com.cassioconti.flightsearch.core;

public class QueryBuilder implements IQueryBuilder {
    public String build(String from, String to, String startDate, String endDate, int numberOfAdults, int maxPriceUsd, String saleCountry){
        return String.format("{\n" +
                "  \"request\": {\n" +
                "    \"slice\": [\n" +
                "      {\n" +
                "        \"origin\": \"%1$s\",\n" +
                "        \"destination\": \"%2$s\",\n" +
                "        \"date\": \"%3$s\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"origin\": \"%2$s\",\n" +
                "        \"destination\": \"%1$s\",\n" +
                "        \"date\": \"%4$s\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"passengers\": {\n" +
                "      \"adultCount\": %5$d,\n" +
                "      \"infantInLapCount\": 0,\n" +
                "      \"infantInSeatCount\": 0,\n" +
                "      \"childCount\": 0,\n" +
                "      \"seniorCount\": 0\n" +
                "    },\n" +
                "    \"solutions\": 500,\n" +
                "    \"maxPrice\": \"USD%6$d\",\n" +
                "    \"saleCountry\": \"%7$s\",\n" +
                "    \"refundable\": false\n" +
                "  }\n" +
                "}", from, to, startDate, endDate, numberOfAdults, maxPriceUsd, saleCountry);
    }
}