package com.caio.springregisterlogin.auth.service;

import com.caio.springregisterlogin.auth.model.Funcao;
import com.caio.springregisterlogin.auth.model.Usuario;
import com.caio.springregisterlogin.auth.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUserName(username);
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority>grantedAuthorities = new HashSet<>();
        for(Funcao funcao : usuario.getFuncoes()){
            grantedAuthorities.add(new SimpleGrantedAuthority((funcao.getNomeCargo())));
        }
        return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(), grantedAuthorities);
    }
}
