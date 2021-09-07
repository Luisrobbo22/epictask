package br.com.fiap.epictask.service.impl;

import br.com.fiap.epictask.model.Usuario;
import br.com.fiap.epictask.service.UsuarioService;
import br.com.fiap.epictask.utils.StringUtils;
import br.com.fiap.epictask.validator.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioValidator UsuarioValidator;

    public UsuarioServiceImpl(UsuarioValidator usuarioValidator) {
        UsuarioValidator = usuarioValidator;
    }

    @Override
    public void validarSenha(Usuario usuario) {
        BeanPropertyBindingResult erros = new BeanPropertyBindingResult(usuario, "usuario");
        UsuarioValidator.validate(usuario, erros);
    }
}
