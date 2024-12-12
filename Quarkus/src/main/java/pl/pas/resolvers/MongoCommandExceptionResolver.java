package pl.pas.resolvers;

import com.mongodb.MongoCommandException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;

@Provider
public class MongoCommandExceptionResolver implements ExceptionMapper<MongoCommandException> {

    @Override
    public Response toResponse(MongoCommandException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ExceptionOutputDTO(e.getMessage())).build();
    }
}
