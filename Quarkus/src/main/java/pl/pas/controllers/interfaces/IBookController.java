package pl.pas.controllers.interfaces;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pl.pas.dto.create.BookCreateDTO;
import pl.pas.dto.update.BookUpdateDTO;

import java.util.UUID;

@Path(pl.pas.utils.consts.GeneralConstants.APPLICATION_CONTEXT + "/books")
public interface IBookController {

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createBook(@Valid BookCreateDTO bookCreateDTO);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") UUID id);

    @GET()
    @Path("")
    @QueryParam("title")
    @Produces(MediaType.APPLICATION_JSON)
    Response findByTitle(@QueryParam("title") String title);

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateBook(@PathParam("id") UUID id, @Valid BookUpdateDTO bookUpdateDTO);

    @DELETE
    @Path("{id}")
    Response deleteBook(@PathParam("id") UUID id);

    @POST
    @Path("{id}/archive/")
    Response archiveBook(@PathParam("id") UUID id);

    @POST
    @Path("{id}/activate/")
    Response activateBook(@PathParam("id") UUID id);
}
