package br.com.roberto.rest.sso.service;

import br.com.roberto.rest.sso.exception.ApiException;

public interface ApiClientService {

    SSOToken getTokenSSO() throws ApiException;

    String post(String urlRest, String body , Sistema nomeSistema) throws ApiException;

    String get(String urlRest , Sistema nomeSistema ) throws ApiException;

    String put(String urlRest, String body , Sistema nomeSistema) throws ApiException;

}
