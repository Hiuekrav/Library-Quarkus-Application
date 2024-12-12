package pl.pas.dto.create;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import pl.pas.dto.ValidationConstants;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record RentCreateDTO (
        @FutureOrPresent
        LocalDateTime beginTime,
        LocalDateTime endTime,

        @NotNull(message = ValidationConstants.READER_ID_BLANK)
        UUID readerId,

        @NotNull(message = ValidationConstants.BOOK_ID_BLANK)
        UUID bookId
) {}
