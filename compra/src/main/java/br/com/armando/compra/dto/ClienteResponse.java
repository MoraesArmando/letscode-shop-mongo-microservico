package br.com.armando.compra.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {

    private String username;
    private String password;
    private String cpf;
    private Boolean status;

}
