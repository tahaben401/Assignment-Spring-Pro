package com.example.microservicespro.controller;


import com.example.microservicespro.model.Person;
import com.example.microservicespro.repository.PersonRepository;
import com.example.microservicespro.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    final private PersonService personService;
    @GetMapping()
    public ResponseEntity<List<Person>> findAll(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") long id){
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Person> add(@RequestBody Person person){
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") long id){
        try {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
