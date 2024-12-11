package pl.pas.controllers.interfaces;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pl.pas.dto.create.UserCreateDTO;
import pl.pas.dto.update.UserUpdateDTO;
import pl.pas.utils.consts.GeneralConstants;

import java.util.UUID;

@Path(GeneralConstants.APPLICATION_CONTEXT + "/users")
public interface IUserController {

    @POST
    @Path("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createAdmin(@Valid UserCreateDTO userCreateDTO);

    @POST
    @Path("librarian")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createLibrarian(@Valid UserCreateDTO userCreateDTO);

    @POST
    @Path("reader")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createReader(@Valid UserCreateDTO userCreateDTO);

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") UUID id);

    @GET
    @Path("")
    @QueryParam("email")
    @Produces(MediaType.APPLICATION_JSON)
    Response findByEmail(@QueryParam("email") String email);

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateUser(@PathParam("id") UUID id, @Valid UserUpdateDTO userUpdateDTO);

    @POST
    @Path("{id}/activate")
    Response activateUser(@PathParam("id") UUID id);

    @POST
    @Path("{id}/deactivate")
    Response deactivateUser(@PathParam("id") UUID id);

}
