package br.com.armando.cliente.dto;

import br.com.armando.cliente.model.Cliente;
import lombok.*;

@Getter
@Setter
@Builder
public class ClienteRequest {

    private String username;
    private String password;
    private String cpf;
    private Boolean status;

    public static ClienteRequest converte(Cliente cliente){
        return ClienteRequest.builder()
                .username(cliente.getUsername())
                .password(cliente.getPassword())
                .cpf(cliente.getCpf())
                .status(cliente.getStatus())
                .build();
    }

}
