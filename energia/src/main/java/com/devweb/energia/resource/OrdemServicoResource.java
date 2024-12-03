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

import com.devweb.energia.model.OrdemServico;
import com.devweb.energia.service.EmpresaLuzService;

@Path("/ordens-servico")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class OrdemServicoResource {

	private EmpresaLuzService service = new EmpresaLuzService();

	@GET
	public Response getAllOrdensServico() {
		return Response.ok(service.getAllOrdensServico()).build();
	}

	@GET
	@Path("/{id}")
	public Response getOrdemServicoById(@PathParam("id") Long id) {
		return Response.ok(service.getOrdemServicoById(id)).build();
	}

	@POST
	public Response createOrdemServico(OrdemServico ordemServico) {
		service.createOrdemServico(ordemServico);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateOrdemServico(@PathParam("id") Long id, OrdemServico ordemServico) {
		service.updateOrdemServico(id, ordemServico);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteOrdemServico(@PathParam("id") Long id) {
		service.deleteOrdemServico(id);
		return Response.noContent().build();
	}
}
