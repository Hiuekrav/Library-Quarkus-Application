package pl.pas.controllers.implementations;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import pl.pas.controllers.interfaces.IRentController;
import pl.pas.dto.create.RentCreateDTO;
import pl.pas.dto.create.RentCreateShortDTO;
import pl.pas.dto.output.RentOutputDTO;
import pl.pas.dto.update.RentUpdateDTO;
import pl.pas.exceptions.rent.RentNotFoundException;
import pl.pas.model.Rent;
import pl.pas.services.interfaces.IRentService;
import pl.pas.utils.mappers.RentMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class RentController implements IRentController {

    private final IRentService rentService;

    private final String rentCreatedURI = "rents/%s";

    @Override
    public Response createRent(RentCreateDTO rentCreateDTO) {
        Rent rent = rentService.createRent(rentCreateDTO);
        return Response.created(URI.create(rentCreatedURI.formatted(rent.getId())))
                .entity(RentMapper.toRentOutputDTO(rent))
                .build();
    }

    @Override
    public Response createRentNow(RentCreateShortDTO rentCreateShortDTO) {
        Rent rent = rentService.createRentWithUnspecifiedTime(rentCreateShortDTO);
        return Response.created(URI.create(rentCreatedURI.formatted(rent.getId())))
                .entity(RentMapper.toRentOutputDTO(rent))
                .build();
    }

    // General

    @Override
    public Response findAllFuture() {
        List<Rent> rents = rentService.findAllFuture();
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }


    @Override
    public Response findAllActive() {
        List<Rent> rents = rentService.findAllActive();
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }


    @Override
    public Response findAllArchive() {
        List<Rent> rents = rentService.findAllArchive();
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }


    // By Rent
    @Override
    public Response findAllRents() {
        List<Rent> rents = rentService.findAll();
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findById(UUID id) {
        try {
            Rent rent = rentService.findRentById(id);
            return Response.ok(RentMapper.toRentOutputDTO(rent)).build();
        } catch (RentNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    // By Reader
    @Override
    public Response findAllByReaderId(UUID readerId) {
        List<Rent> rents = rentService.findAllByReaderId(readerId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findAllFutureByReaderId(UUID readerId) {
        List<Rent> rents = rentService.findAllFutureByReaderId(readerId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findAllActiveByReaderId(UUID readerId) {
        List<Rent> rents = rentService.findAllActiveByReaderId(readerId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findAllArchivedByReaderId(UUID readerId) {
        List<Rent> rents = rentService.findAllArchivedByReaderId(readerId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    // By Book
    @Override
    public Response findAllByBookId(UUID bookId) {
        List<Rent> rents = rentService.findAllByBookId(bookId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findAllFutureByBookId(UUID bookId) {
        List<Rent> rents = rentService.findAllFutureByBookId(bookId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }


    @Override
    public Response findAllActiveByBookId(UUID bookId) {
        List<Rent> rents = rentService.findAllActiveByBookId(bookId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }

    @Override
    public Response findAllArchivedByBookId(UUID bookId) {
        List<Rent> rents = rentService.findAllArchivedByBookId(bookId);
        if (rents.isEmpty()) return Response.noContent().build();
        return Response.ok(rents.stream().map(RentMapper::toRentOutputDTO).toList()).build();
    }



    @Override
    public Response updateRent(UUID id, RentUpdateDTO updateDTO) {
        Rent updatedRent = rentService.updateRent(id, updateDTO);
        RentOutputDTO outputDTO = RentMapper.toRentOutputDTO(updatedRent);
        return Response.ok(outputDTO).build();
    }

    @Override
    public Response endRent(UUID rentId) {
        rentService.endRent(rentId);
        return Response.noContent().build();
    }

    @Override
    public Response deleteRent(UUID id) {
        rentService.deleteRent(id);
        return Response.noContent().build();
    }
}
