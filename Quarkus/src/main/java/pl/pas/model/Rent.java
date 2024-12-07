package pl.pas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pas.mgd.RentMgd;
import pl.pas.model.users.User;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter @Setter
public class Rent extends AbstractEntity {

    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private User reader;
    private Book book;

    public Rent(UUID id, LocalDateTime beginTime, LocalDateTime endTime, User reader, Book book) {
        super(id);
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.reader = reader;
        this.book = book;
    }

    public Rent(RentMgd rentMgd, User reader, Book book) {
        super(rentMgd.getId());
        this.beginTime = rentMgd.getBeginTime();
        this.endTime = rentMgd.getEndTime();
        this.reader = reader;
        this.book = book;
    }

    public Rent(RentMgd rentMgd) {
        super(rentMgd.getId());
        this.beginTime = rentMgd.getBeginTime();
        this.endTime = rentMgd.getEndTime();
    }

    public Rent(UUID id, LocalDateTime endTime, User reader, Book book) {
        super(id);
        this.beginTime = LocalDateTime.now();
        this.endTime = endTime;
        this.reader = reader;
        this.book = book;
    }

    public Rent(LocalDateTime beginTime, LocalDateTime endTime, User reader, Book book) {
        super(null);
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.reader = reader;
        this.book = book;
    }

    public Rent(LocalDateTime endTime, User reader, Book book) {
        super(null);
        this.beginTime = LocalDateTime.now();
        this.endTime = endTime;
        this.reader = reader;
        this.book = book;
    }
}
