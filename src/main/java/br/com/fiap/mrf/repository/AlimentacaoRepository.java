package br.com.fiap.mrf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mrf.models.Refeicao;

public interface AlimentacaoRepository extends JpaRepository<Refeicao, Long> {
    
}
