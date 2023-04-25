package br.com.fiap.mrf.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import br.com.fiap.mrf.models.Refeicao;
import br.com.fiap.mrf.models.Users;
import br.com.fiap.mrf.repository.RefeicaoRepository;
import br.com.fiap.mrf.repository.UsersRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
 
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Override
    public void run(String... args) throws Exception {

       Users user1 = new Users(1L, "João", "24/07/1993", "email1@email.com","123");
       Users user2 = new Users(2L, "Alberto", "16/05/2000", "email2@email.com","456");
       Users user3 = new Users(3L, "Thiago", "30/01/1997", "email3@email.com","789");
       usersRepository.saveAll(List.of(user1, user2, user3));

       refeicaoRepository.saveAll(List.of(
            Refeicao.builder().
            dia(LocalDate.now()).
            horario(LocalTime.now()).
            tipo("Café da manhã").
            refeicao("Pão com ovo").
            bebida("Suco de Laranja").
            calorias(200).
            user(user1).
            build(),

            Refeicao.builder().
            dia(LocalDate.now()).
            horario(LocalTime.now()).
            tipo("Almoço").
            refeicao("PFzão brabo").
            bebida("Suco de Maracuja").
            calorias(600).
            user(user1).
            build(),

            Refeicao.builder().
            dia(LocalDate.now()).
            horario(LocalTime.now()).
            tipo("Janta").
            refeicao("Cachorro quente").
            bebida("Suco de Uva").
            calorias(400).
            user(user1).
            build()
       ));
    }

    
}
