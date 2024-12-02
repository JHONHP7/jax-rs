package com.devweb.energia.resource;

import com.devweb.energia.model.Equipe;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/equipes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
public class EquipeResource {

	private EmpresaLuzService empresaLuzService = new EmpresaLuzService();

	@GET
	public Response listarEquipes() {
		List<Equipe> equipes = empresaLuzService.listarEquipes();
		return Response.ok(equipes).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionarEquipe(Equipe equipe) {
		empresaLuzService.adicionarEquipe(equipe);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{codigo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarEquipe(@PathParam("codigo") String codigo, Equipe equipe) {
		empresaLuzService.atualizarEquipe(codigo, equipe);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codigo}")
	public Response removerEquipe(@PathParam("codigo") String codigo) {
		empresaLuzService.removerEquipe(codigo);
		return Response.noContent().build();
	}
}
