package com.santt4na.rest_springboot3.controller;

import java.util.List;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rest_springboot3.model.Person;
import com.santt4na.rest_springboot3.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

   @Autowired // Spring Cuida da Instanciacao
   private PersonService service;

   // GetMapping = RequestMapping + Metodo GET
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Person> findAll() {
      return service.findAll();
   }

   // GetMapping = RequestMapping + Metodo GET
   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public Person findById(@PathVariable(value = "id") Long id) throws Exception {
      Person person = service.findById(id);
      if (person == null) {
         throw new Exception("Person no can be null");
      }
      return person;
   }

   // PostMapping = RequestMapping + Metodo POST
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, // Produz JSON
         consumes = MediaType.APPLICATION_JSON_VALUE // Consume um JSON
   )
   public Person create(@RequestBody Person person) throws Exception {
      return service.create(person);
   }

   // PutMapping = RequestMapping + Metodo PUT
   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, // Produz JSON
         consumes = MediaType.APPLICATION_JSON_VALUE // Consume um JSON
   )
   public Person update(@RequestBody Person person) {
      return service.update(person);
   }

   // DeleteMapping = RequestMapping + Metodo DELETE
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
      service.delete(id);
      return ResponseEntity.noContent().build();
   }

}