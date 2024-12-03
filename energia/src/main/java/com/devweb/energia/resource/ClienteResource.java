package com.devweb.energia.resource;

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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/clientes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClienteResource {

	private EmpresaLuzService service = new EmpresaLuzService();

	@GET
	public Response getAllClientes() {
		return Response.ok(service.getAllClientes()).build();
	}

	@GET
	@Path("/{id}")
	public Response getClienteById(@PathParam("id") Long id) {
		return Response.ok(service.getClienteById(id)).build();
	}

	@POST
	public Response createCliente(Cliente cliente) {
		service.createCliente(cliente);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateCliente(@PathParam("id") Long id, Cliente cliente) {
		service.updateCliente(id, cliente);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCliente(@PathParam("id") Long id) {
		service.deleteCliente(id);
		return Response.noContent().build();
	}
}
