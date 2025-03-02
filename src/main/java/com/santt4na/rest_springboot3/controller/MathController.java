package com.santt4na.rest_springboot3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rest_springboot3.exception.UnsupportedMathOperationException;

@RestController()
public class MathController {
   // private static final String template = "Helo, %s";
   // private final AtomicLong counter = new AtomicLong();

   /*
    * RequestMapping -> Basicamente é uma anotação generica
    * Podendo ser mais especifico com o GetMapping, PostMapping, DeleteMapping
    * etc..
    * 
    * Diferenças entre o @PathVariable X @RequestParam
    * Ambos são usados para extrair informações da URL, mas de maneiras diferentes:
    * 
    * @PathVariable -> Obrigatorio passar
    * Captura valores que fazem parte do caminho da URL.
    * ex: http://localhost:8080/usuarios/123
    * 123 é capturado.
    * 
    * @RequestParam -> Opcional ser passado, Captura valores de parâmetros de
    * consulta (query parameters) da URL.
    * ex: http://localhost:8080/usuarios?nome=Joao
    * Joao é capturado como o valor do parâmetro nome.
    */
   @RequestMapping(value = "/sum/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double sum(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!isNumeric(numOne) || !isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return ConvetToDouble(numOne) + ConvetToDouble(numTwo);
   }

   @RequestMapping(value = "/sub/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double sub(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!isNumeric(numOne) || !isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }

      if (ConvetToDouble(numOne) < ConvetToDouble(numTwo)) {
         return ConvetToDouble(numTwo) - ConvetToDouble(numOne);
      } else {
         return ConvetToDouble(numOne) - ConvetToDouble(numTwo);
      }
   }

   @RequestMapping(value = "/mul/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double mul(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!isNumeric(numOne) || !isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return ConvetToDouble(numOne) * ConvetToDouble(numTwo);
   }

   @RequestMapping(value = "/div/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double div(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!isNumeric(numOne) || !isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return ConvetToDouble(numOne) / ConvetToDouble(numTwo);
   }

   @RequestMapping(value = "/med/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double med(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!isNumeric(numOne) || !isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      Double soma = ConvetToDouble(numOne) + ConvetToDouble(numTwo);
      return soma / 2;
   }

   @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
   public Double med(
         @PathVariable(value = "number") String number) throws Exception {
      if (!isNumeric(number)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return Math.sqrt(ConvetToDouble(number));
   }

   private Double ConvetToDouble(String strNum) {
      if (strNum == null)
         return 0D;
      String number = strNum.replaceAll(",", ".");
      if (isNumeric(number)) {
         return Double.parseDouble(number);
      }
      return 0D;
   }

   private boolean isNumeric(String strNum) {
      if (strNum == null)
         return false;
      String number = strNum.replaceAll(",", ".");
      return number.matches("[-+]?[0-9]*\\.?[0-9]+");
   }

}
