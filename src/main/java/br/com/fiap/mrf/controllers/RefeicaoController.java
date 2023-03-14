package br.com.fiap.mrf.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefeicaoController {

    @GetMapping("/api/v1/ver-alimentacao")
    public String index(){
       return "olaaaa";
    }
}
