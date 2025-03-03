package com.santt4na.rest_springboot3.controller;

import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rest_springboot3.model.Person;
import com.santt4na.rest_springboot3.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

   @Autowired // Spring Cuida da Instanciacao
   private PersonService service;

   // private final AtomicLong counter = new AtomicLong();

   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Person> findAll() {
      return service.findAll();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public Person findById(@PathVariable(value = "id") String id) throws Exception {
      Person person = service.findById(id);
      if (person == null) {
         throw new Exception("Person no can be null");
      }
      return person;
   }

}
