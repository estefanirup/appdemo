package br.edu.utfpr.appdemo.dtos;

import java.time.LocalDate;

public record LembreteDTO(
    String mensagem,
    LocalDate dataHora
) {

}
