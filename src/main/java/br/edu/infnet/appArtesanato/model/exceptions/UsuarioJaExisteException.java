package br.edu.infnet.appArtesanato.model.exceptions;

public class UsuarioJaExisteException extends Exception{
    public UsuarioJaExisteException(String mensagem) {
        super(mensagem);
    }

}
