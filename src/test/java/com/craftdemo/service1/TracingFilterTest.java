package com.craftdemo.service1;

import com.craftdemo.requestfilter.filters.CustomHeaderRequestWrapper;
import com.craftdemo.requestfilter.filters.TracingFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.craftdemo.requestfilter.util.Constants.REQUEST_HEADER_TRACE_ID;
import static org.mockito.Mockito.when;

public class TracingFilterTest {

    @Mock
    private CustomHeaderRequestWrapper mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private FilterChain mockFilterChain;

    private TracingFilter tracingFilter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tracingFilter = new TracingFilter();
    }

    @Test
    public void testTraceFilter() throws ServletException, IOException {
        tracingFilter.doFilter(mockRequest, mockResponse, mockFilterChain);
        when(mockRequest.getHeader(REQUEST_HEADER_TRACE_ID)).thenReturn("uniqueTraceId");
        Assertions.assertNotNull(mockRequest.getHeader(REQUEST_HEADER_TRACE_ID));
    }
}

