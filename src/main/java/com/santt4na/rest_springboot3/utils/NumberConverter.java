package com.santt4na.rest_springboot3.utils;

public class NumberConverter {

   public static Double ConvetToDouble(String strNum) {
      if (strNum == null)
         return 0D;
      String number = strNum.replaceAll(",", ".");
      if (isNumeric(number)) {
         return Double.parseDouble(number);
      }
      return 0D;
   }

   public static boolean isNumeric(String strNum) {
      if (strNum == null)
         return false;
      String number = strNum.replaceAll(",", ".");
      return number.matches("[-+]?[0-9]*\\.?[0-9]+");
   }
}
