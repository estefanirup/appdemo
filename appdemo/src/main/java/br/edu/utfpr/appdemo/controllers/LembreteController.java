package br.edu.utfpr.appdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.appdemo.dtos.LembreteDTO;
import br.edu.utfpr.appdemo.models.Lembrete;
import br.edu.utfpr.appdemo.services.LembreteService;

@RestController
@RequestMapping("/person/{pessoaId}/lembretes")
public class LembreteController {
    private LembreteService lembreteService;

    public LembreteController(LembreteService lembreteService) {
        this.lembreteService = lembreteService;
    }

    @PostMapping

    public Lembrete criar(@PathVariable String pessoaId, @RequestBody LembreteDTO dto) {
        return lembreteService.salvar(pessoaId, dto);
    }
}
