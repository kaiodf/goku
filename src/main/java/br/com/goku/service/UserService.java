package br.com.goku.service;

import br.com.goku.dto.UserDto;
import br.com.goku.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    UserDto get(Long id);
    User getByEmail(String email);
    List<UserDto> getAll();
}
