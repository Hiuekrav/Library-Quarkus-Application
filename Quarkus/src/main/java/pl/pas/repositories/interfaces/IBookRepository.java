package pl.pas.repositories.interfaces;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import pl.pas.mgd.BookMgd;
import pl.pas.mgd.BookMgd;

import java.util.List;
import java.util.UUID;

@DefaultBean
public interface IBookRepository extends IObjectRepository<BookMgd> {

    BookMgd findById(UUID id);

    List<BookMgd> findByTitle(String plateNumber);

    BookMgd changeRentedStatus(UUID id, Boolean status);

    void changeArchiveStatus(UUID id, Boolean status);

    void deleteAll();
}
