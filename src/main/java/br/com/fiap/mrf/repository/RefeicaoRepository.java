package br.com.fiap.mrf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mrf.models.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    
}
