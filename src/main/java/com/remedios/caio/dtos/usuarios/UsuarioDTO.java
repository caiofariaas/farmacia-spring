package com.remedios.caio.dtos.usuarios;

import com.remedios.caio.entities.Usuario;

public record UsuarioDTO(

        Long id,
        String nome,
        String login,
        String senha,
        Boolean ativo
) {

    public UsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getAtivo());
    }
}
