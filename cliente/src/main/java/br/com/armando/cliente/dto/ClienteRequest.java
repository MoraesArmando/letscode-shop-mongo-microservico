package br.com.armando.cliente.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteRequest {

    private String username;
    private String password;
    private String cpf;
    private Boolean status;

}
