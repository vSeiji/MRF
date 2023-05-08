package br.com.fiap.mrf.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    RefeicaoRepository repository;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<Refeicao> index(){
        return repository.findAll();
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
        repository.delete(getRefeicao(id));
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
        repository.save(refeicao);
        return ResponseEntity.ok(refeicao);
    }
//------------------------------------------------------------------------------------------------------------------
    private Refeicao getRefeicao(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Refeição não encontrada"));
    }
}
