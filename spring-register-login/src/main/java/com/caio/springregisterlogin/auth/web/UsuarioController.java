package com.caio.springregisterlogin.auth.web;

import com.caio.springregisterlogin.auth.model.Usuario;
import com.caio.springregisterlogin.auth.service.SecurityService;
import com.caio.springregisterlogin.auth.service.UsuarioService;
import com.caio.springregisterlogin.auth.validator.UsuarioValidador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class UsuarioController {

    private UsuarioService usuarioService;
    private SecurityService securityService;
    private UsuarioValidador usuarioValidador;

    @GetMapping("/registro")
    public String registration(Model model){
        model.addAttribute("userForm", new Usuario());
        return"registro";
    }

    @PostMapping("/registro")
    public String registration(@ModelAttribute("userForm") Usuario usuario, BindingResult result){
        usuarioValidador.validate(usuario, result);
        if(result.hasErrors()){
            return "registration";
        }
        usuarioService.save(usuario);
        securityService.autoLogin(usuario.getUserName(), usuario.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error", "Seu nome de usuario e senha sao invalidos.");
        }
        if(logout != null){
            model.addAttribute("message", "Voce deslogou com sucesso.");
        }
        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
