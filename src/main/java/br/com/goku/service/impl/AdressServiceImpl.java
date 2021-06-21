package br.com.goku.service.impl;

import br.com.goku.dto.AdressDto;
import br.com.goku.model.Adress;
import br.com.goku.repository.AdressRepository;
import br.com.goku.repository.UserRepository;
import br.com.goku.service.AdressService;
import com.google.common.base.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements AdressService {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AdressDto findByCep(String cep) {
        if(Strings.isNullOrEmpty(cep)){
           return null;
        }else {
            ModelMapper mapper = new ModelMapper();
            Adress adress = adressRepository.findbyCep(cep);
            return mapper.map(adress, AdressDto.class);
        }
    }

    @Override
    public Adress create(Adress adress) {
//        if(Objects.nonNull(endereco.getUser())) {
//            User user = userRepository.getOne(endereco.getUser().getId());
//            endereco.setUser(user);
//        }
        return adressRepository.save(adress);
    }
}
