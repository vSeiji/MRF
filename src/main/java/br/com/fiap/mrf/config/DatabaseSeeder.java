package br.com.fiap.mrf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.mrf.repository.UsersRepository;

public class DatabaseSeeder implements CommandLineRunner {
 
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    
}
