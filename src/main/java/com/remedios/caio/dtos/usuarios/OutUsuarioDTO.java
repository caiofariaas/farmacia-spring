package com.remedios.caio.dtos.usuarios;

import com.remedios.caio.entities.Usuario;

public record OutUsuarioDTO(

        Long id,
        String nome,
        String login

) {

    public OutUsuarioDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getLogin()
                );
    }
}
