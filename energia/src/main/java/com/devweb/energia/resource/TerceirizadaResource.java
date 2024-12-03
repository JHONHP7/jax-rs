package com.devweb.energia.resource;

import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 * Recurso para gerenciamento de empresas terceirizadas.
 */
@Path("/terceirizadas")
public class TerceirizadaResource {

	private final EmpresaLuzService service = new EmpresaLuzService();

	/**
	 * Deleta uma empresa terceirizada pelo ID.
	 *
	 * @param id o ID da empresa terceirizada.
	 * @return mensagem de confirmação no formato text/plain.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteTerceirizada(@PathParam("id") Long id) {
		service.deleteTerceirizada(id);
		return Response.ok("Empresa terceirizada deletada com sucesso").build();
	}
}
