package br.com.goku.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private String email;
    private String name;
    private String password;
    private Timestamp createdAt;

    private List<AdressDto> adresses;
}
