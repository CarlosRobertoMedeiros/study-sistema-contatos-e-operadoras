package br.com.roberto.rest.sso.exception;

public class ApiException extends RuntimeException {

    public ApiException(String mensagem) {
        super(mensagem);
    }
}
