package br.com.roberto.rest;

import org.omg.CORBA.Request;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SistemaContatosTest {

    public static void main(String []args){
        getContatos();
    }


    public static  void getContatos(){

        /*Client client = ClientBuilder.newClient().build();
        String entity =
                client.target("http://localhost:8080/br.com.roberto.backend-sistema-contatos-api-1.0-SNAPSHOT")
                .path("/v1/contatos")
                .request(MediaType.APPLICATION_JSON).header("some-header","true").get(String.class);

        System.out.println(entity);*/

    }



}
