package br.com.fiap.mrf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mrf.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
    Optional<Users> findByEmail(String email);

}
