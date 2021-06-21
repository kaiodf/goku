package br.com.goku.controller;

import br.com.goku.dto.AdressDto;
import br.com.goku.model.Adress;
import br.com.goku.service.AdressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AdressControllerTest {

    @InjectMocks
    AdressController adressController;

    @Mock
    AdressService adressService;

    @Test
    public void create(){
        Adress adress = loadAdress();
        Mockito.when(adressService.create(Mockito.any(Adress.class))).thenReturn(adress);
        ResponseEntity<HttpStatus> responseEntity = adressController.create(adress);
        Assert.assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
    }

    @Test
    public void findByCep(){
        Mockito.when(adressService.findByCep(Mockito.anyString())).thenReturn(loadAdressDto());
        ResponseEntity<AdressDto> responseEntity = adressController.findByCep("01234567");
        Assert.assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
    }

    @Test
    public void findByCepNull(){
        ResponseEntity<AdressDto> responseEntity = adressController.findByCep(null);
        Assert.assertEquals(responseEntity.getStatusCode(),HttpStatus.NO_CONTENT);
    }

    private AdressDto loadAdressDto() {
        AdressDto dto = new AdressDto();
        dto.setCep("01234567");
        return dto;
    }

    private Adress loadAdress() {
        Adress adress = new Adress();
        adress.setId(1L);
        return adress;
    }
}
