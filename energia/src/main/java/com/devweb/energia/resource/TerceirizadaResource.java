package com.devweb.energia.resource;

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

import com.devweb.energia.model.Terceirizada;
import com.devweb.energia.service.EmpresaLuzService;

@Path("/terceirizadas")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TerceirizadaResource {

	private EmpresaLuzService service = new EmpresaLuzService();

	@GET
	public Response getAllTerceirizadas() {
		return Response.ok(service.getAllTerceirizadas()).build();
	}

	@GET
	@Path("/{id}")
	public Response getTerceirizadaById(@PathParam("id") Long id) {
		return Response.ok(service.getTerceirizadaById(id)).build();
	}

	@POST
	public Response createTerceirizada(Terceirizada terceirizada) {
		service.createTerceirizada(terceirizada);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateTerceirizada(@PathParam("id") Long id, Terceirizada terceirizada) {
		service.updateTerceirizada(id, terceirizada);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTerceirizada(@PathParam("id") Long id) {
		service.deleteTerceirizada(id);
		return Response.noContent().build();
	}
}
