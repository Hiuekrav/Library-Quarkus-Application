package pl.pas.resolvers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;
import pl.pas.exceptions.user.EmailAlreadyExistException;
import pl.pas.exceptions.user.UserBaseException;

@Provider
public class UserBaseExceptionResolver implements ExceptionMapper<UserBaseException> {

    @Override
    public Response toResponse(UserBaseException e) {

        if ( e instanceof EmailAlreadyExistException) {
            return Response.status(Response.Status.CONFLICT).entity(new ExceptionOutputDTO(e.getMessage())).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity((new ExceptionOutputDTO(e.getMessage()))).build();
    }
}
