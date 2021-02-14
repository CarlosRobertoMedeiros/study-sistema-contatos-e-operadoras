package br.com.roberto.rest;


import br.com.roberto.dto.ContatoDto;
import br.com.roberto.exceptions.ContatoNaoEncontradoException;
import br.com.roberto.service.ContatoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contatos")
public class ContatosRest {

    @Inject
    private ContatoService contatoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContatos(){
        try {
            List<ContatoDto> contatos = contatoService.recuperaContatos();
            return Response.ok(contatos).build();
        }catch (ContatoNaoEncontradoException e){
            return Response.noContent().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getContato(@PathParam("id") Long id) {
        try {
            ContatoDto contatoDto = contatoService.recuperaContatoPor(id);
            return Response.ok(contatoDto).build();
        } catch (ContatoNaoEncontradoException e){
            return Response.noContent().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criaContato(ContatoDto contato){
        contatoService.adicionaContato(contato);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response atualizaContato(@PathParam("id") Long id, ContatoDto contato){

        ContatoDto contatoDtoInterno = contatoService.atualizaContato(id,contato);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response excluiContato(@PathParam("id") Long id) {

        boolean removeuContato = contatoService.removeContato(id);

        if (removeuContato){
            return Response.status(202).entity("Usuário Excluido com Sucesso !!").build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }




}
