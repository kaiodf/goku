package br.com.goku.service.impl;

import br.com.goku.dto.AdressDto;
import br.com.goku.model.Adress;
import br.com.goku.repository.AdressRepository;
import br.com.goku.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdressServiceImplTest {
    @InjectMocks
    AdressServiceImpl adressService;

    @Mock
    AdressRepository adressRepository;

    @Mock
    UserRepository userRepository;

    @Test
    public void findByCep(){
        Mockito.when(adressRepository.findbyCep(Mockito.anyString())).thenReturn(loadAdress());
        AdressDto adressDto = adressService.findByCep("1234567");
        Assert.assertEquals("123",adressDto.getCep());
    }

    @Test
    public void findByCepNull(){
        AdressDto adressDto = adressService.findByCep(null);
        Assert.assertNull(adressDto);
    }

    @Test
    public void create(){
        Mockito.when(adressRepository.save(Mockito.any(Adress.class))).thenReturn(loadAdress());
        Adress adress = adressService.create(loadAdress());
        Assert.assertEquals("123",adress.getCep());
    }

    private Adress loadAdress() {
        Adress adress = new Adress();
        adress.setId(1L);
        adress.setCep("123");
        return adress;
    }
}
