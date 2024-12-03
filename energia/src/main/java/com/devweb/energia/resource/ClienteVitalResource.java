package com.devweb.energia.resource;

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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes-vitais")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClienteVitalResource {

	private EmpresaLuzService service = new EmpresaLuzService();

	@GET
	public Response getAllClientesVitais() {
		return Response.ok(service.getAllClientesVitais()).build();
	}

	@GET
	@Path("/{id}")
	public Response getClienteVitalById(@PathParam("id") Long id) {
		return Response.ok(service.getClienteVitalById(id)).build();
	}

	@POST
	public Response createClienteVital(ClienteVital clienteVital) {
		service.createClienteVital(clienteVital);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateClienteVital(@PathParam("id") Long id, ClienteVital clienteVital) {
		service.updateClienteVital(id, clienteVital);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteClienteVital(@PathParam("id") Long id) {
		service.deleteClienteVital(id);
		return Response.noContent().build();
	}
}
