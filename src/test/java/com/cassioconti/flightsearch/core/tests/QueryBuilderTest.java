package com.cassioconti.flightsearch.core.tests;

import com.cassioconti.flightsearch.core.QueryBuilder;
import org.junit.Assert;
import org.junit.Test;

public class QueryBuilderTest {
    @Test
    public void TestHappyPath1() {
        QueryBuilder queryBuilder = new QueryBuilder();
        String actual = queryBuilder.build("FLN", "IAH", "2017-07-07", "2017-07-22", 4, 7200, "US");

        String expected = "{\n" +
                "  \"request\": {\n" +
                "    \"slice\": [\n" +
                "      {\n" +
                "        \"origin\": \"FLN\",\n" +
                "        \"destination\": \"IAH\",\n" +
                "        \"date\": \"2017-07-07\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"origin\": \"IAH\",\n" +
                "        \"destination\": \"FLN\",\n" +
                "        \"date\": \"2017-07-22\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"passengers\": {\n" +
                "      \"adultCount\": 4,\n" +
                "      \"infantInLapCount\": 0,\n" +
                "      \"infantInSeatCount\": 0,\n" +
                "      \"childCount\": 0,\n" +
                "      \"seniorCount\": 0\n" +
                "    },\n" +
                "    \"solutions\": 500,\n" +
                "    \"maxPrice\": \"USD7200\",\n" +
                "    \"saleCountry\": \"US\",\n" +
                "    \"refundable\": false\n" +
                "  }\n" +
                "}";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestHappyPath2() {
        QueryBuilder queryBuilder = new QueryBuilder();
        String actual = queryBuilder.build("MGF", "HOU", "2017-07-14", "2017-07-29", 3, 5000, "BR");

        String expected = "{\n" +
                "  \"request\": {\n" +
                "    \"slice\": [\n" +
                "      {\n" +
                "        \"origin\": \"MGF\",\n" +
                "        \"destination\": \"HOU\",\n" +
                "        \"date\": \"2017-07-14\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"origin\": \"HOU\",\n" +
                "        \"destination\": \"MGF\",\n" +
                "        \"date\": \"2017-07-29\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"passengers\": {\n" +
                "      \"adultCount\": 3,\n" +
                "      \"infantInLapCount\": 0,\n" +
                "      \"infantInSeatCount\": 0,\n" +
                "      \"childCount\": 0,\n" +
                "      \"seniorCount\": 0\n" +
                "    },\n" +
                "    \"solutions\": 500,\n" +
                "    \"maxPrice\": \"USD5000\",\n" +
                "    \"saleCountry\": \"BR\",\n" +
                "    \"refundable\": false\n" +
                "  }\n" +
                "}";

        Assert.assertEquals(expected, actual);
    }
}