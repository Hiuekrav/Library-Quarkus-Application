package pl.pas.resolvers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;
import pl.pas.exceptions.ApplicationDatabaseException;
@Provider
public class ApplicationDatabaseExceptionResolver implements ExceptionMapper<ApplicationDatabaseException> {

    @Override
    public Response toResponse(ApplicationDatabaseException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ExceptionOutputDTO(e.getMessage())).build();
    }
}
