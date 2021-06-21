package br.com.goku.controller;

import br.com.goku.dto.AdressDto;
import br.com.goku.model.Adress;
import br.com.goku.service.AdressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Api
@RestController
@RequestMapping(value = "/adress")
public class AdressController {

    @Autowired
    AdressService adressService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Adress adress) {
        adressService.create(adress);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "{cep}", method = RequestMethod.GET)
    public ResponseEntity<AdressDto> findByCep(@PathVariable("cep") String cep){
        AdressDto dto = adressService.findByCep(cep);
        if(Objects.nonNull(dto)) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
