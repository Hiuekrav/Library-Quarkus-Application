package pl.pas.controllers.interfaces;

import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import pl.pas.dto.create.RentCreateDTO;
import pl.pas.dto.create.RentCreateShortDTO;
import pl.pas.dto.update.RentUpdateDTO;
import pl.pas.utils.consts.GeneralConstants;

import java.util.UUID;

//@Path(pl.pas.utils.consts.GeneralConstants.APPLICATION_CONTEXT + "/rents")
//public interface IRentController {
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> createRent(@Valid @RequestBody RentCreateDTO rentCreateDTO);
//
//    @PostMapping(path = "now",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> createRentNow(@Valid @RequestBody RentCreateShortDTO rentCreateShortDTO);
//
//    @GetMapping(path = "future", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> findAllFuture();
//
//    @GetMapping(path = "active", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> findAllActive();
//
//    @GetMapping(path = "archive", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> findAllArchive();
//
//    @GetMapping("all")
//    ResponseEntity<?> findAllRents();
//
//    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<?> findById(@PathVariable("id") UUID id);
//
//    @GetMapping("reader/{id}/all")
//    ResponseEntity<?> findAllByReaderId(@PathVariable("id") UUID readerId);
//
//    @GetMapping("reader/{id}/active")
//    ResponseEntity<?> findAllActiveByReaderId(@PathVariable("id") UUID readerId);
//
//    @GetMapping("reader/{id}/archive")
//    ResponseEntity<?> findAllArchivedByReaderId(@PathVariable("id") UUID readerId);
//
//    @GetMapping("reader/{id}/future")
//    ResponseEntity<?> findAllFutureByReaderId(@PathVariable("id") UUID readerId);
//
//    @GetMapping("book/{id}/all")
//    ResponseEntity<?> findAllByBookId(@PathVariable("id") UUID bookId);
//
//    @GetMapping("book/{id}/active")
//    ResponseEntity<?> findAllActiveByBookId(@PathVariable("id") UUID bookId);
//
//    @GetMapping("book/{id}/archive")
//    ResponseEntity<?> findAllArchivedByBookId(@PathVariable("id") UUID bookId);
//
//    @GetMapping("book/{id}/future")
//    ResponseEntity<?> findAllFutureByBookId(@PathVariable("id") UUID bookId);
//
//    @PutMapping("{id}")
//    ResponseEntity<?> updateRent(@PathVariable("id") UUID id, @Valid @RequestBody RentUpdateDTO endTime);
//
//    @PostMapping("/{id}/end")
//    ResponseEntity<?> endRent(@PathVariable("id") UUID rentId);
//
//    @DeleteMapping("{id}")
//    ResponseEntity<?> deleteRent(@PathVariable("id") UUID id);
//
//}
