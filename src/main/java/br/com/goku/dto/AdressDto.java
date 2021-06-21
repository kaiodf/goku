package br.com.goku.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AdressDto {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
}
