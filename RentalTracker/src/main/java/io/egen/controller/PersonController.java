package io.egen.controller;

import io.egen.entity.Person;
import io.egen.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "users")
public class PersonController {

    @Autowired
    private PersonService service;

    //POST & PUT Combined
    //@CrossOrigin(origins ="http://localhost:8080/RentalTracker")
    @RequestMapping(method = RequestMethod.PUT
           )
    public void create(@RequestBody List<Person> person) {
        service.createOrUpdate(person);
    }

    // GET all persons
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    //GET person by id
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person findOne(@PathVariable("id") String personId) {
        return service.findOne(personId);
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String personId) {
        service.delete(personId);
    }
}


