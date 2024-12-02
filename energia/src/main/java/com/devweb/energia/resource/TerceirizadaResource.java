package com.devweb.energia.resource;

import com.devweb.energia.model.Terceirizada;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/terceirizadas")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
public class TerceirizadaResource {

	private EmpresaLuzService empresaLuzService = new EmpresaLuzService();

	@GET
	public Response listarTerceirizadas() {
		List<Terceirizada> terceirizadas = empresaLuzService.listarTerceirizadas();
		return Response.ok(terceirizadas).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionarTerceirizada(Terceirizada terceirizada) {
		empresaLuzService.adicionarTerceirizada(terceirizada);
		return Response.status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("/{codigo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarTerceirizada(@PathParam("codigo") String codigo, Terceirizada terceirizada) {
		empresaLuzService.atualizarTerceirizada(codigo, terceirizada);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{codigo}")
	public Response removerTerceirizada(@PathParam("codigo") String codigo) {
		empresaLuzService.removerTerceirizada(codigo);
		return Response.noContent().build();
	}
}
