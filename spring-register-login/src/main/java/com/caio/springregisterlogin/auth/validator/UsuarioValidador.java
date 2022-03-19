package com.caio.springregisterlogin.auth.validator;

import com.caio.springregisterlogin.auth.model.Usuario;
import com.caio.springregisterlogin.auth.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Component
public class UsuarioValidador implements Validator {

    private UsuarioService usuarioService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
         Usuario usuario = (Usuario) target;

         //se o nome de usuario for < 6 ou > 32
        //se o nome de usuario nao for nulo
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if(usuario.getUserName().length() < 6 || usuario.getUserName().length() > 32){
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(usuarioService.findUsuarioByNome(usuario.getUserName()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        //se a senha for < 8 ou > 32
        //se a confirmacao da senha for diferente
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(usuario.getPassword().length() < 8 || usuario.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(!usuario.getPasswordConfirm().equals(usuario.getPassword())){
            errors.rejectValue("password", "Diff.userForm.passwordConfirm");
        }
    }
}
