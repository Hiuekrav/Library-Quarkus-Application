package pl.pas.services.interfaces;

import pl.pas.dto.create.UserCreateDTO;
import pl.pas.dto.update.UserUpdateDTO;
import pl.pas.model.users.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {


    User createAdmin(UserCreateDTO createDTO);

    User createLibrarian(UserCreateDTO createDTO);

    User createReader(UserCreateDTO createDTO);

    User findById(UUID id);

    List<User> findAll();

    List<User> findByEmail(String email);

    User updateUser(UserUpdateDTO updateDTO);

    void deactivateUser(UUID id);

    void activateUser(UUID id);

    void deleteAll();
}
