package br.com.fiap.mrf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.mrf.repository.UsersRepository;

@Service
public class AuthenticationService implements UserDetailsService{
    
    @Autowired
    UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                    .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
