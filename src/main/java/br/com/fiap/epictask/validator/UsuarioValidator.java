package br.com.fiap.epictask.validator;

import br.com.fiap.epictask.Enums.CampoValidacao;
import br.com.fiap.epictask.Enums.ErroUsuario;
import br.com.fiap.epictask.Exception.EpictaskException;
import br.com.fiap.epictask.model.Usuario;
import br.com.fiap.epictask.utils.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UsuarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        validarSenha(usuario);
    }

    private void validarSenha(Usuario usuario) {

        if(!StringUtils.validarPatternSenha(usuario)){
            throw new EpictaskException(ErroUsuario.ERRO_USUARIO03,
                    usuario.getPassword(),
                    CampoValidacao.PASSWORD
                    )
        }
    }
}
