package com.devweb.energia.resource;

import com.devweb.energia.model.Cliente;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

/**
 * Recurso responsável pelo gerenciamento de clientes.
 */
@Path("/clientes")
public class ClienteResource {

	private final EmpresaLuzService service = new EmpresaLuzService();

	/**
	 * Retorna todos os clientes ou faz uma busca por nome usando QueryParam.
	 *
	 * @param nome o nome do cliente (opcional).
	 * @return lista de clientes no formato JSON ou XML.
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response getAllClientes(@QueryParam("nome") String nome) {
		List<Cliente> clientes = (nome != null)
				? service.getAllClientes().stream().filter(cliente -> cliente.getNome().contains(nome)).toList()
				: service.getAllClientes();
		return Response.ok(clientes).build();
	}

	/**
	 * Retorna um cliente específico pelo ID.
	 *
	 * @param id o ID do cliente.
	 * @return cliente no formato JSON.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClienteById(@PathParam("id") Long id) {
		return Response.ok(service.getClienteById(id)).build();
	}

	/**
	 * Cria um novo cliente.
	 *
	 * @param cliente os dados do cliente.
	 * @return resposta indicando criação bem-sucedida.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCliente(Cliente cliente) {
		service.createCliente(cliente);
		return Response.status(Response.Status.CREATED).build();
	}

	/**
	 * Atualiza os dados de um cliente.
	 *
	 * @param id      o ID do cliente.
	 * @param cliente os dados atualizados do cliente.
	 * @return resposta de sucesso.
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCliente(@PathParam("id") Long id, Cliente cliente) {
		service.updateCliente(id, cliente);
		return Response.ok().build();
	}

	/**
	 * Deleta um cliente pelo ID.
	 *
	 * @param id o ID do cliente.
	 * @return mensagem de sucesso.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteCliente(@PathParam("id") Long id) {
		service.deleteCliente(id);
		return Response.ok("Cliente deletado com sucesso").build();
	}
}
