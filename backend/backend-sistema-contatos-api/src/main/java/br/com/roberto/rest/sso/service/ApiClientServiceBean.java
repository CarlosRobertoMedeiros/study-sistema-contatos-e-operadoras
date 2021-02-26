package br.com.roberto.rest.sso.service;

import br.com.roberto.rest.sso.exception.ApiException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Stateless
public class ApiClientServiceBean implements ApiClientService{

    private static final String CONTENT_TYPE = "Content-Type";
    private static SSOToken token;

    @Override
    public SSOToken getTokenSSO() throws ApiException {
        if (token == null
                || ChronoUnit.SECONDS.between(token.getDataHoraToken(), LocalDateTime.now()) > token.getExpires_in()) {

            try {
                String tokenUrl = "http://localhost:8080/auth/realms/demo/protocol/openid-connect/token";
                String secret = "dbf0f313-0132-4108-b7c2-5a5b50a8fc02";
                String user = "app";

                URL url = new URL(tokenUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");

                conn.setRequestProperty(CONTENT_TYPE, "application/x-www-form-urlencoded");
                String input = "grant_type=client_credentials&client_id=" + user + "&client_secret=" + secret;

                OutputStream os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                ObjectMapper mapper = new ObjectMapper();
                String output = br.readLine();

                if (output != null) {
                    token = mapper.readValue(output, SSOToken.class);
                    token.setDataHoraToken(LocalDateTime.now());
                }
                conn.disconnect();


            } catch (MalformedURLException mue) {
                mue.printStackTrace();
                throw new ApiException("Erro na formação da URL do serviço de recuperação do token");
            } catch (ProtocolException pe) {
                pe.printStackTrace();
                throw new ApiException("Erro na definição do protocolo do serviço de recuperação do token");
            } catch (JsonMappingException jme) {
                jme.printStackTrace();
                throw new ApiException("Erro na leitura do JSon de retorno do serviço de recuperação do token");
            } catch (IOException ioe) {
                ioe.printStackTrace();
                throw new ApiException("Erro de IO na chamada ao serviço de recuperação do token");
            }
        }
        return token;
    }

    @Override
    public String post(String urlRest, String body, Sistema nomeSistema) throws ApiException {
        return null;
    }

    @Override
    public String get(String urlRest, Sistema nomeSistema) throws ApiException {
        return null;
    }

    @Override
    public String put(String urlRest, String body, Sistema nomeSistema) throws ApiException {
        return null;
    }
}
