package br.com.fiap.mrf.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/alimentacao")
@Slf4j
public class AlimentacoesController {
    
    @Autowired
    UsersRepository userRepository;
    
    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;
//------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size=5) Pageable pageable){
        var refeicoes = (busca == null) ?
            refeicaoRepository.findAll(pageable):
            refeicaoRepository.findByTipoContaining(busca, pageable);
        return assembler.toModel(refeicoes.map(Refeicao::toEntityModel));
    }
//------------------------------------------------------------------------------------------------------------------
    @GetMapping("/refeicoes/{id}")
    public EntityModel<Refeicao> show(@PathVariable Long id){
        log.info("Buscando refeição:" + id);
        return getRefeicao(id).toEntityModel();
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
    public ResponseEntity<EntityModel<Refeicao>> update(
        @PathVariable Long id, 
        @RequestBody @Valid Refeicao refeicao){

        log.info("Atualizando refeição:" + id);
        getRefeicao(id);
        refeicao.setId(id);
        refeicaoRepository.save(refeicao);
        return ResponseEntity.ok(refeicao.toEntityModel());
    }
//------------------------------------------------------------------------------------------------------------------
    private Refeicao getRefeicao(Long id) {
        return refeicaoRepository.findById(id).orElseThrow(
            () -> new RestNotFoundException("Refeição não encontrada"));
    }
}
