package com.remedios.caio.services;

import com.remedios.caio.dtos.usuarios.OutUsuarioDTO;
import com.remedios.caio.dtos.usuarios.enums.UserRole;
import com.remedios.caio.entities.Usuario;
import com.remedios.caio.exceptions.NotFoundException;
import com.remedios.caio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // USER DETAILS

    public UserDetails getByLogin(String login) {

        UserDetails user = repository.findByLogin(login);

        if (user == null) {
            throw new BadCredentialsException("");
        }

        System.out.println("USUARIO SERVICE - " + user.getUsername());
        return user;
    }

    // CRUD

    public List<OutUsuarioDTO> getAll() {
        return this.repository.findAllByAtivoTrue().stream().map(OutUsuarioDTO::new).toList();
    }

    // SALVAR NO BANCO

    public void save(Usuario usuario) {

        if (repository.findByLogin(usuario.getLogin()) != null) {
            throw new IllegalArgumentException("This login is already being used!");
        }

        this.repository.save(usuario);
    }

    // DESATIVAR USUÁRIO

    public OutUsuarioDTO inativar(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

        usuario.setAtivo(false);

        return new OutUsuarioDTO(usuario);
    }

    // ATIVAR USUÁRIO

    public OutUsuarioDTO ativar(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

        usuario.setAtivo(true);

        return new OutUsuarioDTO(usuario);
    }

    // SETAR ROLES

    public OutUsuarioDTO setPrivilege (Long id, UserRole role){

        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

        usuario.setRole(role);

        return new OutUsuarioDTO(usuario);
    }
}
