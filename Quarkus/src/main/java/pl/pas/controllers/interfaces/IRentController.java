package pl.pas.controllers.interfaces;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import pl.pas.dto.create.RentCreateDTO;
import pl.pas.dto.create.RentCreateShortDTO;
import pl.pas.dto.update.RentUpdateDTO;

import java.util.UUID;

@Path(pl.pas.utils.consts.GeneralConstants.APPLICATION_CONTEXT + "/rents")
public interface IRentController {

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createRent(@Valid RentCreateDTO rentCreateDTO);

    @POST
    @Path("now")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createRentNow(@Valid RentCreateShortDTO rentCreateShortDTO);

    @GET
    @Path("future")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllFuture();

    @GET
    @Path("active")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllActive();

    @GET
    @Path("archive")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllArchive();

    @GET
    @Path("all")
    Response findAllRents();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") UUID id);

    @GET
    @Path("reader/{id}/all")
    Response findAllByReaderId(@PathParam("id") UUID readerId);

    @GET
    @Path("reader/{id}/active")
    Response findAllActiveByReaderId(@PathParam("id") UUID readerId);

    @GET
    @Path("reader/{id}/archive")
    Response findAllArchivedByReaderId(@PathParam("id") UUID readerId);

    @GET
    @Path("reader/{id}/future")
    Response findAllFutureByReaderId(@PathParam("id") UUID readerId);

    @GET
    @Path("book/{id}/all")
    Response findAllByBookId(@PathParam("id") UUID bookId);

    @GET
    @Path("book/{id}/active")
    Response findAllActiveByBookId(@PathParam("id") UUID bookId);

    @GET
    @Path("book/{id}/archive")
    Response findAllArchivedByBookId(@PathParam("id") UUID bookId);

    @GET
    @Path("book/{id}/future")
    Response findAllFutureByBookId(@PathParam("id") UUID bookId);

    @PUT
    @Path("{id}")
    Response updateRent(@PathParam("id") UUID id, @Valid RentUpdateDTO endTime);

    @POST
    @Path("/{id}/end")
    Response endRent(@PathParam("id") UUID rentId);

    @DELETE
    @Path("{id}")
    Response deleteRent(@PathParam("id") UUID id);

}
