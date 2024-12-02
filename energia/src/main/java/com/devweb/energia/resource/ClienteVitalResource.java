package com.devweb.energia.resource;

import java.util.List;

import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientesvital")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class ClienteVitalResource {

    private EmpresaLuzService empresaLuzService = new EmpresaLuzService(); // Instância manual

    // Endpoint para listar todos os clientes vitais
    @GET
    public Response listarClientesVitais() {
        List<ClienteVital> clientesVitais = empresaLuzService.listarClientesVitais();
        return Response.ok(clientesVitais).build();
    }

    // Endpoint para adicionar um cliente vital
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response adicionarClienteVital(ClienteVital clienteVital) {
        boolean sucesso = empresaLuzService.adicionarClienteVital(clienteVital);
        
        if (sucesso) {
            return Response.status(Response.Status.CREATED)
                           .entity("Cliente vital cadastrado com sucesso!") // Mensagem de sucesso
                           .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Falha ao cadastrar cliente vital!") // Mensagem de falha
                           .build();
        }
    }

    // Endpoint para atualizar um cliente vital
    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarClienteVital(@PathParam("cpf") String cpf, ClienteVital clienteVital) {
        boolean sucesso = empresaLuzService.atualizarClienteVital(cpf, clienteVital);
        
        if (sucesso) {
            return Response.ok().entity("Cliente vital atualizado com sucesso!").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Falha ao atualizar cliente vital!").build();
        }
    }

    // Endpoint para remover um cliente vital
    @DELETE
    @Path("/{cpf}")
    public Response removerClienteVital(@PathParam("cpf") String cpf) {
        empresaLuzService.removerClienteVital(cpf);
        return Response.noContent().build();
    }

    // Endpoint para buscar um cliente vital pelo nome
    @GET
    @Path("/buscar")
    public Response buscarClienteVitalPorNome(@QueryParam("nome") String nome) {
        List<ClienteVital> clientesVitais = empresaLuzService.buscarClienteVitalPorNome(nome);
        
        if (clientesVitais.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("Nenhum cliente vital encontrado com o nome: " + nome).build();
        }
        
        return Response.ok(clientesVitais).build();
    }
}
