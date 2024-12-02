package com.devweb.energia.resource;

import java.util.List;

import com.devweb.energia.model.OS;
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

@Path("/os")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class OSResource {

    private EmpresaLuzService empresaLuzService = new EmpresaLuzService();

    @GET
    public Response listarOS() {
        List<OS> ordens = empresaLuzService.listarOrdens();
        return Response.ok(ordens).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarOS(OS os) {
        empresaLuzService.adicionarOS(os);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarOS(@PathParam("codigo") String codigo, OS os) {
        empresaLuzService.atualizarOS(codigo, os);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response removerOS(@PathParam("codigo") String codigo) {
        empresaLuzService.removerOS(codigo);
        return Response.noContent().build();
    }
}
