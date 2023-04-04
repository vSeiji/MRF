package br.com.fiap.mrf.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import jakarta.validation.Valid;

@RestController
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(RefeicaoController.class);
    
    @Autowired
    RefeicaoRepository repository; //IoD

    @PostMapping("/api/v1/refeicao")
    public ResponseEntity<Refeicao> create(
        @RequestBody @Valid Refeicao refeicao, BindingResult result){
        
        log.info("cadastrando refeicao" + refeicao);
        repository.save(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    

}
