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

import com.devweb.energia.model.Equipe;
import com.devweb.energia.service.EmpresaLuzService;

@Path("/equipes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EquipeResource {

	private EmpresaLuzService service = new EmpresaLuzService();

	@GET
	public Response getAllEquipes() {
		return Response.ok(service.getAllEquipes()).build();
	}

	@GET
	@Path("/{id}")
	public Response getEquipeById(@PathParam("id") Long id) {
		return Response.ok(service.getEquipeById(id)).build();
	}

	@POST
	public Response createEquipe(Equipe equipe) {
		service.createEquipe(equipe);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateEquipe(@PathParam("id") Long id, Equipe equipe) {
		service.updateEquipe(id, equipe);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEquipe(@PathParam("id") Long id) {
		service.deleteEquipe(id);
		return Response.noContent().build();
	}
}
