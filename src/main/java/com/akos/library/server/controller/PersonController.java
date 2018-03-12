package com.akos.library.server.controller;

import com.akos.library.common.entity.Person;
import com.akos.library.server.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/person")
public class PersonController {

    PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
        repository.save(new Person("Jack", "White"));
        repository.save(new Person("John", "Doe"));
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersons() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id ) {
        return repository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Person person) {
        repository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id ) {
        repository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody Person person ) {
        person.setId(id);
        repository.save(person);
    }

}