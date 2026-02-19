package com.example.microservicespro.service;


import com.example.microservicespro.model.Person;
import com.example.microservicespro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    final private PersonRepository personRepository;
    public List<Person> getPersons(){
        return personRepository.findAll();
    }
    public Person getPersonById(long id){
        return personRepository.findById(id).orElseThrow();
    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public void deletePerson(long id) throws Exception {
        if(personRepository.existsById(id)){
            personRepository.deleteById(id);
        }
        else {
            throw new Exception("Person not found");
        }

    }
    public void delete(Person person){
        personRepository.delete(person);
    }
}
