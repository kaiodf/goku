package br.com.goku.controller;

import br.com.goku.dto.UserDto;
import br.com.goku.model.User;
import br.com.goku.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    public void findById(){
        Mockito.when(userService.get(Mockito.anyLong())).thenReturn(loadUserDto());
        ResponseEntity<UserDto> responseEntity = userController.findById(1L);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void findByIdNull(){
        ResponseEntity<UserDto> responseEntity = userController.findById(null);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void findAll(){
        Mockito.when(userService.getAll()).thenReturn(loadList());
        ResponseEntity<List<UserDto>> responseEntity = userController.findAll();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void create(){
        ResponseEntity<HttpStatus> responseEntity = userController.create(new User());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    private List<UserDto> loadList() {
        List<UserDto> list = new ArrayList<>();
        list.add(loadUserDto());
        return list;
    }

    private UserDto loadUserDto() {
        UserDto userDto = new UserDto();
        userDto.setEmail("email");
        return userDto;
    }

}
