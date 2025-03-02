package com.santt4na.rest_springboot3.exception;

import java.io.Serializable;
import java.util.Date;

// Serializable pq em caso de apps grandes podemos fazer cache da instancia da classe
// ou trafegar dados pela rede entre outras coisas.
public class ExceptionResponse implements Serializable {

   private static final long serialVersionUID = 1L;

   private Date timestamp;
   private String message;
   private String details;

   public ExceptionResponse(Date timestamp, String message, String details) {
      this.timestamp = timestamp;
      this.message = message;
      this.details = details;
   }

   public Date getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Date timestamp) {
      this.timestamp = timestamp;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }
}
