package pl.pas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@Getter
public abstract class AbstractEntity implements Serializable {

    private UUID id;

    public AbstractEntity(UUID id) {
        this.id = id;
    }
}
