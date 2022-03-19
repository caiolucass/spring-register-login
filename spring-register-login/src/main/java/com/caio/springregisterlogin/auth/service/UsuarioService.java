package com.caio.springregisterlogin.auth.service;

import com.caio.springregisterlogin.auth.model.Usuario;

public interface UsuarioService {
    void save(Usuario usuario);
    Usuario findUsuarioByNome(String username);
}
