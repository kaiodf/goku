package br.com.goku.controller;

import br.com.goku.dto.UserDto;
import br.com.goku.model.User;
import br.com.goku.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Api
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        if(Objects.isNull(id)){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
