package br.com.goku.service;

import br.com.goku.dto.AdressDto;
import br.com.goku.model.Adress;

public interface AdressService {

    AdressDto findByCep(String cep);
    Adress create(Adress adress);
}
