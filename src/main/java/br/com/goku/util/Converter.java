package br.com.goku.util;

import org.modelmapper.ModelMapper;

public class Converter {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <D> Object toModel(final Object user, Class<D> outClass) {
        return modelMapper.map(user , outClass);

    }

}
