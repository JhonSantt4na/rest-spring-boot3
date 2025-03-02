package com.santt4na.rest_springboot3.controller;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rest_springboot3.exception.UnsupportedMathOperationException;
import com.santt4na.rest_springboot3.math.SimpleMath;
import com.santt4na.rest_springboot3.utils.NumberConverter;

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

   // private final AtomicLong counter = new AtomicLong();
   private SimpleMath math = new SimpleMath();

   @RequestMapping(value = "/sum/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double sum(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return math.sum(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
   }

   @RequestMapping(value = "/sub/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double sub(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }

      if (NumberConverter.ConvetToDouble(numOne) < NumberConverter.ConvetToDouble(numTwo)) {
         return math.sub(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
      } else {
         return math.sub(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
      }
   }

   @RequestMapping(value = "/mul/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double mul(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return math.mul(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
   }

   @RequestMapping(value = "/div/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double div(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return math.div(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
   }

   @RequestMapping(value = "/med/{numOne}/{numTwo}", method = RequestMethod.GET)
   public Double med(
         @PathVariable(value = "numOne") String numOne,
         @PathVariable(value = "numTwo") String numTwo) throws Exception {
      if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return math.med(NumberConverter.ConvetToDouble(numOne), NumberConverter.ConvetToDouble(numTwo));
   }

   @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
   public Double med(
         @PathVariable(value = "number") String number) throws Exception {
      if (!NumberConverter.isNumeric(number)) {
         throw new UnsupportedMathOperationException("Please set a numeric value");
      }
      return math.raiz(NumberConverter.ConvetToDouble(number));
   }
}
