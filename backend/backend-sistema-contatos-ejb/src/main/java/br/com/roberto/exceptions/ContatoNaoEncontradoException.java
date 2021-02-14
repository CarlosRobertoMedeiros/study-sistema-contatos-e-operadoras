package br.com.roberto.exceptions;

public class ContatoNaoEncontradoException extends ContatoServiceException{

    public ContatoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
