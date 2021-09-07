package br.com.fiap.epictask.Exception;

import br.com.fiap.epictask.Enums.ErroUsuario;

public class EpictaskException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final Integer codigoErro;
    private final String campo;
    private final String valor;

    public EpictaskException(ErroUsuario erroUsuario){
        super(erroUsuario.getMensgem());
        this.codigoErro = erroUsuario.getCodigo();
        this.campo = null;
        this.valor = null;
    }

    public EpictaskException(final ErroUsuario erro, final String valor, String campo) {
        super(erro.getMensgem());
        this.codigoErro = erro.getCodigo();
        this.campo = campo;
        this.valor = valor;
    }
}
