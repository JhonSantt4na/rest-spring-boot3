package com.santt4na.rest_springboot3.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santt4na.rest_springboot3.exception.ResouseNotFoundException;
import com.santt4na.rest_springboot3.model.Person;
import com.santt4na.rest_springboot3.repository.PersonRepository;

@Service
public class PersonService {

   @Autowired
   PersonRepository repository;

   // private final AtomicLong counter = new AtomicLong();
   private Logger logger = Logger.getLogger(PersonService.class.getName());

   public List<Person> findAll() {
      logger.info("Finding all people!");
      return repository.findAll();
   }

   public Person findById(Long id) {
      logger.info("Finding One Person");
      return repository.findById(id)
            .orElseThrow(() -> new ResouseNotFoundException("No Records Found for this ID"));

   }

   public Person create(Person person) {
      logger.info("Creating one Person!");
      return repository.save(person);

   }

   public Person update(Person person) {
      logger.info("Updated one Person!");

      var entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResouseNotFoundException("No Records Found for this ID"));

      entity.setFirstName(person.getFirstName());
      entity.setLastName(person.getLastName());
      entity.setAddress(person.getAddress());
      entity.setGender(person.getGender());

      return repository.save(entity);

   }

   public void delete(Long id) {
      logger.info("Deleted one Person!");

      var entity = repository.findById(id)
            .orElseThrow(() -> new ResouseNotFoundException("No Records Found for this ID"));

      repository.delete(entity);
   }
}
