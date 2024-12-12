package pl.pas.resolvers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.pas.dto.output.ExceptionOutputDTO;

import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionResolver implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<ExceptionOutputDTO> exceptionOutputDTOS = e.getConstraintViolations()
                .stream()
                .map(this::mapViolationToDTO)
                .collect(Collectors.toList());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exceptionOutputDTOS)
                .build();
    }

    private ExceptionOutputDTO mapViolationToDTO(ConstraintViolation<?> violation) {
        return new ExceptionOutputDTO(violation.getMessage());
    }
}
