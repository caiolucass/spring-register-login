package com.caio.springregisterlogin.auth.repository;

import com.caio.springregisterlogin.auth.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUserName(String username);
}
