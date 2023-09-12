package com.craftdemo.service1.exceptions;

import com.craftdemo.requestfilter.GlobalExceptionHandler;
import com.craftdemo.service1.controller.HelloController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = {HelloController.class})
public class ExceptionTranslator extends GlobalExceptionHandler {
}
