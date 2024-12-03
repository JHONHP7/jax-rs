package com.devweb.energia.resource;

import com.devweb.energia.model.Equipe;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 * Recurso para gerenciamento de equipes.
 */
@Path("/equipes")
public class EquipeResource {

	private final EmpresaLuzService service = new EmpresaLuzService();

	/**
	 * Retorna uma equipe específica pelo ID.
	 *
	 * @param id o ID da equipe.
	 * @return equipe no formato JSON ou XML.
	 */
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEquipeById(@PathParam("id") Long id) {
		Equipe equipe = service.getEquipeById(id);
		if (equipe != null) {
			return Response.ok(equipe).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Equipe não encontrada").build();
		}
	}
}
