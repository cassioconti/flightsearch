package com.cassioconti.flightsearch.core;

public interface IQueryBuilder {
    String build(String from, String to, String startDate, String endDate, int numberOfAdults, int maxPriceUsd, String saleCountry);
}
