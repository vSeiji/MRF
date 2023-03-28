package br.com.fiap.mrf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;

@RestController
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(RefeicaoController.class);
    
    @Autowired
    RefeicaoRepository repository; //IoD

    @GetMapping("/api/v1/alimentacao")
    public List<Refeicao> index(){
        return repository.findAll();
    }

    @PostMapping("/api/v1/refeicao")
    public ResponseEntity<Refeicao> create(@RequestBody Refeicao refeicao){
        log.info("cadastrando refeicao" + refeicao);
        repository.save(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    @GetMapping("/api/v1/alimentacao/refeicoes/{id}")
    public ResponseEntity<Refeicao> show(@PathVariable Long id){
        log.info("buscando refeicao:" + id);
        var refeicaoEncontrada = repository.findById(id);

        if(refeicaoEncontrada.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


        return ResponseEntity.ok(refeicaoEncontrada.get());
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
    public ResponseEntity<Refeicao> update(@PathVariable Long id, @RequestBody Refeicao refeicao){
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
