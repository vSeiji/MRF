package br.com.fiap.mrf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mrf.models.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    Page<Refeicao> findByTipoContaining(String busca, Pageable pageable);
}
