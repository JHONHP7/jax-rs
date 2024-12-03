package com.devweb.energia.resource;

import com.devweb.energia.model.OrdemServico;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 * Recurso para gerenciamento de Ordens de Serviço.
 */
@Path("/ordens-servico")
public class OrdemServicoResource {

	private final EmpresaLuzService service = new EmpresaLuzService();

	/**
	 * Retorna todas as ordens de serviço.
	 *
	 * @return lista de ordens de serviço no formato JSON.
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllOrdensServico() {
		return Response.ok(service.getAllOrdensServico()).build();
	}

	/**
	 * Cria uma nova ordem de serviço usando parâmetros de formulário.
	 *
	 * @param codigo o código da ordem em formato String (convertido para Long).
	 * @param prioridade a prioridade da ordem, um número entre 1 e 3.
	 * @return resposta indicando criação bem-sucedida ou erro de validação.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createOrdemServico(@FormParam("codigo") String codigo, @FormParam("prioridade") String prioridade) {
		try {
			Long codigoLong = Long.parseLong(codigo);
			int prioridadeInt = Integer.parseInt(prioridade);

			// Valida se a prioridade está entre 1 e 3
			if (prioridadeInt < 1 || prioridadeInt > 3) {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity("A prioridade deve ser um número entre 1 e 3.")
						.type(MediaType.TEXT_PLAIN)
						.build();
			}

			OrdemServico ordem = new OrdemServico();
			ordem.setCodigo(codigoLong);
			ordem.setPrioridade(prioridadeInt); // Assumindo que o campo é int ou Integer

			service.createOrdemServico(ordem);
			return Response.status(Response.Status.CREATED).build();

		} catch (NumberFormatException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("O código e a prioridade devem ser números válidos.")
					.type(MediaType.TEXT_PLAIN)
					.build();
		}
	}


}
