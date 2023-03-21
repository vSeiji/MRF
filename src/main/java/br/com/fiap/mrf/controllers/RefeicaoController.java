package br.com.fiap.mrf.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.mrf.models.Refeicao;

@RestController
public class RefeicaoController {

    @GetMapping("/api/v1/ver-alimentacao")
    
    public Refeicao index(){
        return new Refeicao("1", "15/03/2023", "08:30", "Café da Manhã", "Pão com Queijo e Presunto", "Suco de Laranja", 280 );
    }
}
