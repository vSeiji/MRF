package br.com.fiap.mrf.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import br.com.fiap.mrf.repository.UsersRepository;

public class DatabaseSeeder implements CommandLineRunner {
 
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Override
    public void run(String... args) throws Exception {
    }

    
}
