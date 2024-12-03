package com.devweb.energia.resource;

import com.devweb.energia.model.ClienteVital;
import com.devweb.energia.service.EmpresaLuzService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

/**
 * Recurso para gerenciamento de clientes vitais.
 */
@Path("/clientes-vitais")
public class ClienteVitalResource {

	private final EmpresaLuzService service = new EmpresaLuzService();

	/**
	 * Atualiza um cliente vital usando parâmetros de matrix.
	 *
	 * @param id                 o ID do cliente vital.
	 * @param tempoMaxSemEnergia o tempo máximo sem energia.
	 * @return resposta de sucesso.
	 */
	@PUT
	@Path("/{id}")
	public Response updateClienteVital(@PathParam("id") Long id,
			@MatrixParam("tempoMaxSemEnergia") int tempoMaxSemEnergia) {
		ClienteVital clienteVital = service.getClienteVitalById(id);
		clienteVital.setTempoMaximoSemEnergia(tempoMaxSemEnergia);
		service.updateClienteVital(id, clienteVital);
		return Response.ok().build();
	}
}
