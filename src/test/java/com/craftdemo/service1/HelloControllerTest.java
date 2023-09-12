package com.craftdemo.service1;

import com.craftdemo.requestfilter.CustomHeaderRequestWrapper;
import com.craftdemo.requestfilter.LoggingFilter;
import com.craftdemo.requestfilter.TracingFilter;
import com.craftdemo.service1.controller.HelloController;
import com.craftdemo.service1.service.HelloService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;


@WebMvcTest(value = HelloController.class)
@WithMockUser
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TracingFilter tracingFilter;

    @MockBean
    private LoggingFilter loggingFilter;

    @MockBean
    private HelloService helloService;

    @Mock
    private CustomHeaderRequestWrapper mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private FilterChain mockFilterChain;

    @Test
    public void helloApi() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/hello");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        loggingFilter.doFilter(requestBuilder.buildRequest(mockRequest.getServletContext()), mockResponse, mockFilterChain);
        System.out.println(result.getResponse());
        Mockito.verify(tracingFilter).doFilter(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.verify(loggingFilter).doFilter(Mockito.any(), Mockito.any(), Mockito.any());
    }

}
