package br.edu.utfpr.appdemo.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_lembrete")
@Data
public class Lembrete {
    @Id
    private UUID id = UUID.randomUUID();
    private String mensagem;
    private LocalDateTime dataHora;

    @OneToMany
    @ManyToOne
    private Person person;

}
