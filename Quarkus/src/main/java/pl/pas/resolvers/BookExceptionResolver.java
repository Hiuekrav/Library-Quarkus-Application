package pl.pas.resolvers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;
import pl.pas.exceptions.book.*;

@Provider
public class BookExceptionResolver implements ExceptionMapper<BookBaseException> {

    @Override
    public Response toResponse(BookBaseException e) {
        if (e instanceof BookNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ExceptionOutputDTO(e.getMessage()))
                    .build();
        }

        if (e instanceof BookTitleAlreadyExistException ||
            e instanceof BookArchivedException ||
            e instanceof BookChangeStatusException ||
            e instanceof BookStatusAlreadySetException) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ExceptionOutputDTO(e.getMessage()))
                    .build();
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(new ExceptionOutputDTO(e.getMessage())).build();
    }
}
