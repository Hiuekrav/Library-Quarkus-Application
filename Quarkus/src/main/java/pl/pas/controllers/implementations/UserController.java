package pl.pas.controllers.implementations;


import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import pl.pas.controllers.interfaces.IUserController;
import pl.pas.dto.create.UserCreateDTO;
import pl.pas.dto.output.UserOutputDTO;
import pl.pas.dto.update.UserUpdateDTO;
import pl.pas.exceptions.ApplicationDataIntegrityException;
import pl.pas.model.users.User;
import pl.pas.services.interfaces.IUserService;
import pl.pas.utils.consts.GeneralConstants;
import pl.pas.utils.consts.I18n;
import pl.pas.utils.mappers.UserMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
public class UserController implements IUserController {

    private final IUserService userService;

    private final String userCreateURL = GeneralConstants.APPLICATION_CONTEXT + "/users/%s";

    @Override
    public Response createAdmin(UserCreateDTO userCreateDTO) {
        User createdUser = userService.createAdmin(userCreateDTO);
        UserOutputDTO outputDTO = UserMapper.toUserOutputDTO(createdUser);
        return Response.created(URI.create(userCreateURL.formatted(createdUser.getId())))
                .entity(outputDTO)
                .build();
    }

    @Override
    public Response createLibrarian(UserCreateDTO userCreateDTO) {
        User createdUser = userService.createLibrarian(userCreateDTO);
        UserOutputDTO outputDTO = UserMapper.toUserOutputDTO(createdUser);
        return Response.created(URI.create(userCreateURL.formatted(createdUser.getId())))
                .entity(outputDTO)
                .build();
    }


    @Override
    public Response createReader(UserCreateDTO userCreateDTO) {
        User createdUser = userService.createReader(userCreateDTO);
        UserOutputDTO outputDTO = UserMapper.toUserOutputDTO(createdUser);
        return Response.created(URI.create(userCreateURL.formatted(createdUser.getId())))
                .entity(outputDTO)
                .build();
    }

    @Override
    public Response findById(UUID id) {
        User user = userService.findById(id);
        UserOutputDTO outputDTO = UserMapper.toUserOutputDTO(user);
        return Response.ok(outputDTO).build();
    }

    @Override
    public Response findByEmail(String email) {
        List<User> users = userService.findByEmail(email);
        List<UserOutputDTO> outputDTOList = users.stream().map(UserMapper::toUserOutputDTO).toList();
        if (outputDTOList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(outputDTOList).build();
    }

    @Override
    public Response findAll() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(users.stream().map(UserMapper::toUserOutputDTO).toList()).build();
    }

    @Override
    public Response updateUser(UUID id, UserUpdateDTO userUpdateDTO) {
        if (!userUpdateDTO.id().equals(id)) {
            throw new ApplicationDataIntegrityException(I18n.UPDATE_ID_DO_NOT_MATCH);
        }
        User updatedUser = userService.updateUser(userUpdateDTO);
        UserOutputDTO outputDTO = UserMapper.toUserOutputDTO(updatedUser);
        return Response.ok(outputDTO).build();
    }

    @Override
    public Response activateUser(UUID id) {
        userService.activateUser(id);
        return Response.noContent().build();
    }

    @Override
    public Response deactivateUser(UUID id) {
        userService.deactivateUser(id);
        return Response.noContent().build();
    }
}
