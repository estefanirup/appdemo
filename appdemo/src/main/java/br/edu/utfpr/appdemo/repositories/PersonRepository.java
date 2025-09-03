package br.edu.utfpr.appdemo.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.appdemo.models.Person;

public interface PersonRepository extends JpaRepository<Person, UUID>{


    //Obter por email
    //public List<Person> findByEmail(String email);
}