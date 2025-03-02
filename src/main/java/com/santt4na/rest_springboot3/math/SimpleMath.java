package com.santt4na.rest_springboot3.math;

public class SimpleMath {

   public Double sum(Double numOne, Double numTwo) {
      return numOne + numTwo;
   }

   public Double sub(Double numOne, Double numTwo) {
      if (numOne < numTwo) {
         return numTwo - numOne;
      } else {
         return numOne - numTwo;
      }
   }

   public Double mul(Double numOne, Double numTwo) {
      return numOne * numTwo;
   }

   public Double div(Double numOne, Double numTwo) {
      return numOne / numTwo;
   }

   public Double med(Double numOne, Double numTwo) {
      Double soma = sum(numOne, numTwo);
      return soma / 2;
   }

   public Double raiz(Double number) {
      return Math.sqrt(number);
   }
}
