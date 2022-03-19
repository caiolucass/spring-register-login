package com.caio.springregisterlogin.auth.service;

import com.caio.springregisterlogin.auth.model.Usuario;
import com.caio.springregisterlogin.auth.repository.FuncaoRepository;
import com.caio.springregisterlogin.auth.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;
    private FuncaoRepository funcaoRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Usuario usuario) {
       usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
       usuario.setFuncoes(new HashSet<>(funcaoRepository.findAll()));
       usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findUsuarioByNome(String username) {
        return usuarioRepository.findByUserName(username);
    }
}
