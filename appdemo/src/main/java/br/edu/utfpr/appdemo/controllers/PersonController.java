
package br.edu.utfpr.appdemo.controllers;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.appdemo.models.Person;
import br.edu.utfpr.appdemo.repositories.PersonRepository;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = {"", "/"})
    public String getPerson() {
        return "Oi, eu sou uma pessoa!";
    }

    @GetMapping("/{personId}")
    public ResponseEntity <Person> getById(
        @PathVariable String personId) {

        var uuid = java.util.UUID.fromString(personId);
        var result = personRepository.findById(uuid);

        return result.isPresent() ?
            ResponseEntity.ok(result.get()) :
            ResponseEntity.notFound().build();
    }

    @PostMapping
    public Person create(@RequestBody Person entity) {
        System.out.println(entity);
        personRepository.save(entity);
        return entity;
    }
    

}
