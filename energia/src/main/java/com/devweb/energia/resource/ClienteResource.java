package com.devweb.energia.resource;

import java.util.List;

import com.devweb.energia.model.Cliente;
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

@Path("/clientes")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class ClienteResource {

    private EmpresaLuzService empresaLuzService = new EmpresaLuzService(); // Instância manual

    @GET
    public Response listarClientes() {
        List<Cliente> clientes = empresaLuzService.listarClientes();
        return Response.ok(clientes).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response adicionarCliente(Cliente cliente) {
        boolean sucesso = empresaLuzService.adicionarCliente(cliente);
        
        if (sucesso) {
            return Response.status(Response.Status.CREATED)
                           .entity("Cliente cadastrado com sucesso!") // Mensagem de sucesso
                           .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Falha ao cadastrar cliente!") // Mensagem de falha
                           .build();
        }
    }


    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarCliente(@PathParam("cpf") String cpf, Cliente cliente) {
        empresaLuzService.atualizarCliente(cpf, cliente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cpf}")
    public Response removerCliente(@PathParam("cpf") String cpf) {
        empresaLuzService.removerCliente(cpf);
        return Response.noContent().build();
    }
    
    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public Response buscarClientePorNome(@QueryParam("nome") String nome) {
        List<Cliente> clientes = empresaLuzService.buscarPorNome(nome);
        if (clientes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("Nenhum cliente encontrado com o nome: " + nome).build();
        }
        return Response.ok(clientes).build();
    }

}
