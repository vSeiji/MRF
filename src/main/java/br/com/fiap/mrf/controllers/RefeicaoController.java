package br.com.fiap.mrf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.models.Refeicao;

@RestController
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(RefeicaoController.class);

    List<Refeicao> refeicoes = new ArrayList<>();
    
    @GetMapping("/api/v1/veralimentacao")
    
    public List<Refeicao> index(){
        return refeicoes;
    }

    @PostMapping("/api/v1/cadastrar-refeicao")
    public ResponseEntity<Refeicao> create(@RequestBody Refeicao refeicao){
        log.info("cadastrando refeicao" + refeicao);
        refeicao.setId(refeicoes.size() + 1L);
        refeicoes.add(refeicao);

        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    @GetMapping("/api/v1/veralimentacao/minhasrefeicoes/{id}")
    public ResponseEntity<Refeicao> show(@PathVariable Long id){
        log.info("buscando refeicao:" + id);
        var refeicaoEncontrada = refeicoes.stream().filter(r -> r.getId().equals(id)).findFirst();

        if(refeicaoEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


        return ResponseEntity.ok(refeicaoEncontrada.get());
    }
}
