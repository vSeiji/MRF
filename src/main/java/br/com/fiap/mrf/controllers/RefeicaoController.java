package br.com.fiap.mrf.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import br.com.fiap.mrf.repository.UsersRepository;
import jakarta.validation.Valid;

@RestController
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(RefeicaoController.class);
    
    @Autowired
    UsersRepository userRepository;
    
    @Autowired
    RefeicaoRepository repository; //IoD
//------------------------------------------------------------------------------------------------------------------
    @PostMapping("/api/v1/refeicao")
    public ResponseEntity<EntityModel<Refeicao>> create(
        @RequestBody @Valid Refeicao refeicao, 
        BindingResult result){
        
        log.info("Cadastrando refeição: " + refeicao);
        repository.save(refeicao);
        refeicao.setUser(userRepository.findById(refeicao.getUser().getId()).get());
        return ResponseEntity
            .created(refeicao.toEntityModel().getRequiredLink("self").toUri())
            .body(refeicao.toEntityModel());
    }
}
