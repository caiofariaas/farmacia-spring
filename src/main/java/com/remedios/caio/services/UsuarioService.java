package com.remedios.caio.services;

import com.remedios.caio.dtos.usuarios.InUsuarioDTO;
import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.dtos.usuarios.UsuarioDTO;
import com.remedios.caio.entities.Usuario;
import com.remedios.caio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // USER DETAILS

    public UserDetails getByLogin(String login){

        UserDetails user = repository.findByLogin(login);

        if(user == null){
            throw new BadCredentialsException("Usuário inexistente ou senha inválida");
        }

        System.out.println("USUARIO SERVICE - " + user.getUsername());
        return user;
    }

    // CRUD

    public List<OutUsuarioDTO> getAll(){
        return this.repository.findAllByAtivoTrue().stream().map(OutUsuarioDTO::new).toList();
    }

    public void save(Usuario usuario){
        this.repository.save(usuario);
    }

}
