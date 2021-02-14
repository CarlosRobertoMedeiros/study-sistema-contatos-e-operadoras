package br.com.roberto.rest;

import br.com.roberto.entity.Contato;
import br.com.roberto.entity.Operadora;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//https://www.javaguides.net/2018/06/jersey-jax-rs-restful-crud-web-services-example.html
@Path("/contatos")
public class ContatosRest {

    private static List<Contato> contatos = new ArrayList<>();

    private static Integer ultimoId;
    public ContatosRest() {
        if (contatos.size()==0){
            this.populaDados();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContatos(){
        return Response.ok(contatos).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getContato(@PathParam("id") Integer id){

        Optional<Contato> optContato = contatos.stream().filter(contato -> contato.getId().equals(id)).findAny();
        if (optContato.isPresent()){
            return Response.ok(optContato.get()).build();
        }else{
            return Response.noContent().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criaContato(Contato contato){
        contatos.add(contato);
        ultimoId+=1;
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response atualizaContato(@PathParam("id") Integer id, Contato contato){
        Optional<Contato> optContato = contatos.stream().filter(contatoInt -> contatoInt.getId().equals(id)).findAny();
        if (optContato.isPresent()){
            contatos.remove(optContato.get());
            contatos.add(contato);
            return Response.noContent().build();
        }else{
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response excluiContato(@PathParam("id") Integer id) {
        Optional<Contato> optContato = contatos.stream().filter(contato -> contato.getId().equals(id)).findAny();
        if (optContato.isPresent()) {
            contatos.remove(optContato.get());
            return Response.status(202).entity("Usuário Excluido com Sucesso !!").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private void populaDados(){
        contatos.add(new Contato(1,"","Carlos Roberto Medeiros de Lima","9999-9999",new Operadora(14,"Oi", new BigDecimal(2))));
        contatos.add(new Contato(2,"","Luciene Alves Medeiros de Lima","8888-8888",new Operadora(15,"Vivo", new BigDecimal(1))));
        contatos.add(new Contato(3,"","Ezequias Alves de Lima","7777-7777",new Operadora(41,"Tim", new BigDecimal(3))));
        ultimoId = 3;
    }


}
