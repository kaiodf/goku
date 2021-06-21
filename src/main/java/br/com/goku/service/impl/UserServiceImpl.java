package br.com.goku.service.impl;

import br.com.goku.dto.UserDto;
import br.com.goku.model.Adress;
import br.com.goku.model.User;
import br.com.goku.repository.UserRepository;
import br.com.goku.service.UserService;
import br.com.goku.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        for (Adress end:user.getAdresses()) {
            end.setUser(user);
        }
        String generatedSecuredPasswordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(generatedSecuredPasswordHash);
        return userRepository.save(user);
    }

    @Cacheable(value = "userS", unless = "#result == null")
    public UserDto get(Long id) {
        User user = userRepository.findById(id);
        return (UserDto) Converter.toModel(user,UserDto.class);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> getAll() {
        List<UserDto> list = new ArrayList<>();
        for (User user: userRepository.findAll()) {
            list.add((UserDto) Converter.toModel(user,UserDto.class));
        }
        return list;
    }
}
