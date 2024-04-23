package com.remedios.caio.repositories;

import com.remedios.caio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // TRATAR FORBIDDEN

    UserDetails findByLogin(String login);
}
