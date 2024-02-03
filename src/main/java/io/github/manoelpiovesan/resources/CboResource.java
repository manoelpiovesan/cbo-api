package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.entities.Cbo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cbo")
public class CboResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getByCode(@PathParam("code") String code) {
        Cbo cbo = Cbo.find("code", code).firstResult();
        if (cbo != null) {
            return Response.ok(cbo).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public Response count() {
        return Response.ok(Cbo.count()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {
        return Response.ok(Cbo.findAll().page(page, size).list()).build();
    }

}
