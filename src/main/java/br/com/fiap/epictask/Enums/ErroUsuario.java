package br.com.fiap.epictask.Enums;

public enum ErroUsuario {

    ERRO_USUARIO01(1, "O nome é obrigatório"),
    ERRO_USUARIO02(2, "O e-mail  deve ser um e-mail válido"),
    ERRO_USUARIO03(3, "A senha deve conter pelo menos 8 caracteres, um dígito, um caractere minúsculo, um caracter maiúsculo e um caracter especial");

    private final int codigo;

    private final String mensgem;

    private ErroUsuario(int codigo, String mensgem){
        this.codigo = codigo;
        this.mensgem = mensgem;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getMensgem(){
        return mensgem;
    }

}
