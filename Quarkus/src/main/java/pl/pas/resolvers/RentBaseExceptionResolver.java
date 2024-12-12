package pl.pas.resolvers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;
import pl.pas.exceptions.rent.*;

@Provider
public class RentBaseExceptionResolver implements ExceptionMapper<RentBaseException> {

    @Override
    public Response toResponse(RentBaseException e) {
        if (e instanceof RentCreationException ||
            e instanceof RentDeleteException ||
            e instanceof RentInvalidTimeException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ExceptionOutputDTO(e.getMessage()))
                    .build();
        }
        if (e instanceof RentNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ExceptionOutputDTO(e.getMessage()))
                    .build();
        }


        return Response.status(Response.Status.BAD_REQUEST).entity(new ExceptionOutputDTO(e.getMessage())).build();
    }
}
