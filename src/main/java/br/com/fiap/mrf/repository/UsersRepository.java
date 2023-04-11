package br.com.fiap.mrf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.mrf.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
