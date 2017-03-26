package com.cassioconti.flightsearch.core.tests;

import com.cassioconti.flightsearch.core.IHttpMethod;
import com.cassioconti.flightsearch.core.IQueryBuilder;
import com.cassioconti.flightsearch.core.Retriever;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Scanner;

public class RetrieverTests {
    @Test
    public void TestHappyPath() {
        IHttpMethod httpMethodMock = Mockito.mock(IHttpMethod.class);
        IQueryBuilder queryBuilderMock = Mockito.mock(IQueryBuilder.class);

        try {
            String content = new Scanner(Retriever.class.getResourceAsStream("/EmptyContent.txt")).useDelimiter("\\A").next();
            Mockito.doReturn(content).when(httpMethodMock).doPost(Mockito.anyString());
        } catch (IOException e) {
            Assert.fail("Should not trigger exception");
        }

        Retriever retriever = new Retriever(httpMethodMock, queryBuilderMock);
        retriever.Retrieve(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());

        Mockito.verify(queryBuilderMock, Mockito.times(1)).build(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verifyNoMoreInteractions(queryBuilderMock);

        try {
            Mockito.verify(httpMethodMock, Mockito.times(1)).doPost(Mockito.anyString());
        } catch (IOException e) {
            Assert.fail("Should not trigger exception");
        }

        Mockito.verifyNoMoreInteractions(httpMethodMock);
    }

    @Test
    public void ExceptionShouldBeHandled() {
        IHttpMethod httpMethodMock = Mockito.mock(IHttpMethod.class);
        IQueryBuilder queryBuilderMock = Mockito.mock(IQueryBuilder.class);

        try {
            Mockito.doThrow(new IOException("Test exception")).when(httpMethodMock).doPost(Mockito.anyString());
        } catch (IOException e) {
            Assert.fail("Should not trigger exception here");
        }

        Retriever retriever = new Retriever(httpMethodMock, queryBuilderMock);
        try {
            retriever.Retrieve(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
        } catch (Exception e) {
            Assert.fail("Exception should have being captured");
        }
    }
}
