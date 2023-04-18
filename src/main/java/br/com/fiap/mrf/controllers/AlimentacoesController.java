package br.com.fiap.mrf.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.exception.RestNotFoundException;
import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import br.com.fiap.mrf.repository.UsersRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alimentacao")
public class AlimentacoesController {
    
    Logger log = LoggerFactory.getLogger(RefeicaoController.class);

    @Autowired
    UsersRepository userRepository;
    
    @Autowired
    RefeicaoRepository refeicaoRepository;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public Page<Refeicao> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable){
                           
        if (busca == null) 
            return refeicaoRepository.findAll(pageable);
        return refeicaoRepository.findByTipoContaining(busca, pageable);
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/refeicoes/{id}")
    public ResponseEntity<Refeicao> show(@PathVariable Long id){
        log.info("Buscando refeição:" + id);
        return ResponseEntity.ok(getRefeicao(id));
    }
//------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/refeicoes/{id}")
    public ResponseEntity<Refeicao> destroy(@PathVariable Long id){
        log.info("Apagando refeição:" + id);
        refeicaoRepository.delete(getRefeicao(id));
        return ResponseEntity.noContent().build();
    }
//------------------------------------------------------------------------------------------------------------------
    @PutMapping("/refeicoes/{id}")
    public ResponseEntity<Refeicao> update(
        @PathVariable Long id, 
        @RequestBody @Valid Refeicao refeicao){

        log.info("Atualizando refeição:" + id);
        getRefeicao(id);
        refeicao.setId(id);
        refeicaoRepository.save(refeicao);
        return ResponseEntity.ok(refeicao);
    }
//------------------------------------------------------------------------------------------------------------------
    private Refeicao getRefeicao(Long id) {
        return refeicaoRepository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Refeição não encontrada"));
    }
}
