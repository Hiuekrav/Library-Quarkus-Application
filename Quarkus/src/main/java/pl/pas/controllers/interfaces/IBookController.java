package pl.pas.controllers.interfaces;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pl.pas.dto.create.BookCreateDTO;
import pl.pas.dto.update.BookUpdateDTO;

import javax.print.attribute.standard.Media;
import java.util.UUID;

@Path(pl.pas.utils.consts.GeneralConstants.APPLICATION_CONTEXT + "/books")
public interface IBookController {

    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") UUID id);

    //@PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //ResponseEntity<?> createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO);

    @GET()
    @Path("")
    @QueryParam("title")
    @Produces(MediaType.APPLICATION_JSON)
    Response findByTitle(@QueryParam("title") String title);

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    //@PutMapping(path = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //ResponseEntity<?> updateBook(@PathVariable("id") UUID id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO);
    //
    //@DeleteMapping("{id}")
    //ResponseEntity<?> deleteBook(@PathVariable UUID id);
    //
    //@PostMapping("{id}/archive/")
    //ResponseEntity<?> archiveBook(@PathVariable UUID id);
    //
    //@PostMapping("{id}/activate/")
    //ResponseEntity<?> activateBook(@PathVariable UUID id);
}
