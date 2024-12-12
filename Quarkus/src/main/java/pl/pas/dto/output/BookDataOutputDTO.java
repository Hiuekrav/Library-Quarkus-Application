package pl.pas.dto.output;

import java.util.UUID;

public record BookDataOutputDTO(
        UUID id,
        String title,
        String author,
        String genre
){}
