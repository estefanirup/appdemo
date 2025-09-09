package br.edu.utfpr.appdemo.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.appdemo.dtos.LembreteDTO;
import br.edu.utfpr.appdemo.models.Lembrete;
import br.edu.utfpr.appdemo.models.Person;
import br.edu.utfpr.appdemo.repositories.LembreteRepository;
import br.edu.utfpr.appdemo.repositories.PersonRepository;

@Service
public class LembreteService {
    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private LembreteRepository lembreteRepo;

    public Lembrete salvar(String pessoaId, LembreteDTO dto) {
        Person person = personRepo.findById(UUID.fromString(pessoaId))
                .orElseThrow(() -> 
                new RuntimeException("Pessoa " + pessoaId + " não existe"));
        
        var lembrete = new Lembrete();
        BeanUtils.copyProperties(dto, lembrete);
        lembrete.setPerson(person);

        return lembreteRepo.save(lembrete);
    }

}