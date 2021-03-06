package br.com.roberto.rest.sso.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.temporal.Temporal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SSOToken {
    private Temporal dataHoraToken;
    private String access_token;
    private long expires_in;
    private long refresh_expires_in;
    private String token_type;
    private String refresh_token;

    @JsonProperty("not-before-policy")
    private String notbeforepolicy;
    private String scope;

    public long getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(long refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getNotbeforepolicy() {
        return notbeforepolicy;
    }

    public void setNotbeforepolicy(String notbeforepolicy) {
        this.notbeforepolicy = notbeforepolicy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Temporal getDataHoraToken() {
        return dataHoraToken;
    }

    public void setDataHoraToken(Temporal dataHoraToken) {
        this.dataHoraToken = dataHoraToken;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
