package br.com.fiap.epictask.utils;

import br.com.fiap.epictask.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * Valida se a senha está no padrão correto
     *
     * @param usuario
     * @return boolean
     */
    public static boolean validarPatternSenha(User usuario) {
        final String senhaPattern = "^(?=(?:[^A-Z]*[A-Z]){1})(?=[^!@#$%^&*()+-]*[!@#$%^&*()+-])(?=(?:[^0-9]*[0-9]){1}).{8,}$";


        final Pattern pattern = Pattern.compile(senhaPattern);

        Matcher matcher = pattern.matcher(usuario.getPassword());
        matcher.find();

        return matcher.matches();
    }
}
