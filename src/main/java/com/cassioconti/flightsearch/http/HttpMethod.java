package com.cassioconti.flightsearch.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HttpMethod implements IHttpMethod {
    public String doPost(String jsonContent) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://www.googleapis.com/qpxExpress/v1/trips/search?key=" + getApiKey());
        JsonElement request = new JsonParser().parse(jsonContent);

        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(request.toString()));
        HttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }

    private String getApiKey() {
        InputStream inputStream = HttpMethod.class.getResourceAsStream("/ApiKey.txt");
        return new Scanner(inputStream).next();
    }
}
