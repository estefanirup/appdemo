package br.edu.utfpr.appdemo.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.appdemo.models.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete, UUID> {
    Page<Lembrete> findByPersonId(UUID personId, Pageable pageable);
}
