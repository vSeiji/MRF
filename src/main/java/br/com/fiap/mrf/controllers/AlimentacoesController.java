package br.com.fiap.mrf.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.exception.RestNotFoundException;
import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import jakarta.validation.Valid;

@RestController
public class AlimentacoesController {
    
    Logger log = LoggerFactory.getLogger(RefeicaoController.class);

    @Autowired
    RefeicaoRepository repository;

    @GetMapping("/api/v1/alimentacao")
    public List<Refeicao> index(){
        return repository.findAll();
    }

    @GetMapping("/api/v1/alimentacao/refeicoes/{id}")
    public ResponseEntity<Refeicao> show(@PathVariable Long id){
        log.info("buscando refeicao:" + id);
        var refeicao = getRefeicao(id);
        return ResponseEntity.ok(refeicao);
    }

    private Refeicao getRefeicao(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new RestNotFoundException("refeicao nao encontrada"));
    }

    @DeleteMapping("/api/v1/alimentacao/refeicoes/{id}")
    public ResponseEntity<Refeicao> destroy(@PathVariable Long id){
        log.info("apagando refeicao:" + id);

        var refeicaoEncontrada = repository.findById(id);

        if(refeicaoEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(refeicaoEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/v1/alimentacao/refeicoes/{id}")
    public ResponseEntity<Refeicao> update(@PathVariable Long id, @RequestBody @Valid Refeicao refeicao){
        log.info("atualizando refeicao:" + id);

        var refeicaoEncontrada = repository.findById(id);

        if(refeicaoEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        //BeanUtils.copyProperties(refeicao, refeicaoAtualizada, "id");

        refeicao.setId(id);
        repository.save(refeicao);
        return ResponseEntity.ok(refeicao);
    }
}
