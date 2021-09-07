package br.com.fiap.epictask.Enums;

public enum CampoValidacao {

    EMAIL("email"),
    NOME("nome"),
    PASSWORD("password");

    private final String nomeCampo;

    private CampoValidacao(final String nomeCampo){
        this.nomeCampo = nomeCampo;
    }
}
