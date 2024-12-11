package pl.pas.controllers.implementations;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import pl.pas.dto.create.BookCreateDTO;
import pl.pas.dto.output.BookOutputDTO;
import pl.pas.dto.update.BookUpdateDTO;
import pl.pas.exceptions.book.BookNotFoundException;
import pl.pas.model.Book;
import pl.pas.controllers.interfaces.IBookController;
import pl.pas.services.interfaces.IBookService;
import pl.pas.utils.mappers.BookMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class BookController implements IBookController {

    private final IBookService bookService;

    @Override
    public Response createBook(BookCreateDTO bookCreateDTO) {
        Book book = bookService.createBook(bookCreateDTO);
        BookOutputDTO outputDTO = BookMapper.toBookOutputDTO(book);
        String bookURI =  String.format("/books/%s", outputDTO.id());
        return Response.created(URI.create(bookURI))
                .entity(outputDTO)
                .build();
    }

    @Override
    public Response findById(UUID id) {
        Book book;
        try {
            book = bookService.findBookById(id);
        }
        catch (BookNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

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

    @Override
    public Response updateBook(UUID id, @Valid BookUpdateDTO bookUpdateDTO) {
        Book updatedBook = bookService.updateBook(id, bookUpdateDTO);
        BookOutputDTO outputDTO = BookMapper.toBookOutputDTO(updatedBook);
        return Response.ok(outputDTO).build();
    }

    @Override
    public Response archiveBook(UUID id) {
        bookService.changeArchiveStatus(id, true);
        return Response.noContent().build();
    }

    @Override
    public Response activateBook(UUID id) {
        bookService.changeArchiveStatus(id, false);
        return Response.noContent().build();
    }

    @Override
    public Response deleteBook(UUID id) {
        bookService.deleteBook(id);
        return Response.noContent().build();
    }
}
