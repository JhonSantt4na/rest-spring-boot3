package com.santt4na.rest_springboot3.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.santt4na.rest_springboot3.exception.ExceptionResponse;
import com.santt4na.rest_springboot3.exception.ResouseNotFoundException;

@ControllerAdvice // Sempre que precisamos concentra tudo em um unico controller
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

   // Tratando as Exceptions mais Genericas 404, 500
   @ExceptionHandler(Exception.class) // Qual Exception ele vai tratar
   public final ResponseEntity<ExceptionResponse> handleAllExecptions(Exception ex, WebRequest request) {
      ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
      return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   // Tratando a Nossa Exception
   @ExceptionHandler(ResouseNotFoundException.class) // Qual Exception ele vai tratar
   public final ResponseEntity<ExceptionResponse> handleNotFoundExecptions(Exception ex, WebRequest request) {
      ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
      return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
   }
}
