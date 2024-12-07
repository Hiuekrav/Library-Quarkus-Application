package pl.pas.controllers.implementations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import pl.pas.dto.create.BookCreateDTO;
import pl.pas.dto.output.BookOutputDTO;
import pl.pas.dto.update.BookUpdateDTO;
import pl.pas.exceptions.book.BookNotFoundException;
import pl.pas.model.Book;
import pl.pas.controllers.interfaces.IBookController;
import pl.pas.exceptions.book.BookNotFoundException;
import pl.pas.model.Book;
import pl.pas.services.interfaces.IBookService;
import pl.pas.utils.mappers.BookMapper;
import pl.pas.services.interfaces.IBookService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class BookController implements IBookController {

    private final pl.pas.services.interfaces.IBookService bookService;

    private String bookURI = "/books/%s";

    //@Override
    //public ResponseEntity<?> createBook(BookCreateDTO bookCreateDTO) {
    //    Book book = bookService.createBook(bookCreateDTO);
    //    BookOutputDTO outputDTO = BookMapper.toBookOutputDTO(book);
    //    return ResponseEntity.created(URI.create(bookURI.formatted(outputDTO.id()))).body(outputDTO);
    //}

    @Override
    public Response findById(UUID id) {
        Book book;
        //try {
            book = bookService.findBookById(id);
        //}
        //catch (BookNotFoundException e) {
        //    return Response.status(Response.Status.NOT_FOUND).build();
        //}

        BookOutputDTO outputDTO = BookMapper.toBookOutputDTO(book);
        return Response.ok(outputDTO).build();
    }

    @Override
    public Response findByTitle(String title) {
        List<Book> foundBooks = bookService.findBookByTitle(title);
        if (foundBooks.isEmpty()) return Response.noContent().build();
        return Response.ok(foundBooks.stream().map(BookMapper::toBookOutputDTO)).build();
    }

    @Override
    public Response findAll() {
        List<Book> foundBooks = bookService.findAll();
        if (foundBooks.isEmpty()) return Response.noContent().build();
        return Response.ok(foundBooks.stream().map(BookMapper::toBookOutputDTO)).build();
    }

    //@Override
    //public ResponseEntity<?> updateBook(UUID id, BookUpdateDTO bookUpdateDTO) {
    //    Book updatedBook = bookService.updateBook(id, bookUpdateDTO);
    //    System.out.println(">>>>>End of updateFunction");
    //    BookOutputDTO outputDTO = BookMapper.toBookOutputDTO(updatedBook);
    //    System.out.println(">>>>>End of controller");
    //    return ResponseEntity.ok().body(outputDTO);
    //}
    //
    //@Override
    //public ResponseEntity<?> archiveBook(UUID id) {
    //    bookService.changeArchiveStatus(id, true);
    //    return ResponseEntity.noContent().build();
    //}
    //
    //@Override
    //public ResponseEntity<?> activateBook(UUID id) {
    //    bookService.changeArchiveStatus(id, false);
    //    return ResponseEntity.noContent().build();
    //}
    //
    //@Override
    //public ResponseEntity<?> deleteBook(UUID id) {
    //    bookService.deleteBook(id);
    //    return ResponseEntity.noContent().build();
    //}
}
