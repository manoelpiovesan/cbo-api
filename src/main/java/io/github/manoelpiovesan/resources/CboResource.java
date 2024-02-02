package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.entities.Cbo;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("cbo")
public class CboResource implements PanacheEntityResource<Cbo, Long> {

    @GET
    @Path("/{code}")
    public Response getByCode(@PathParam("code") String code) {
        Cbo cbo = Cbo.find("code", code).firstResult();
        if (cbo != null) {
            return Response.ok(cbo).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
