package br.com.armando.cliente.dto;

import br.com.armando.cliente.model.Cliente;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse{

    private String username;
    private String password;
    private String cpf;
    private Boolean status;

    public static ClienteResponse converte(Cliente cliente) {
        return ClienteResponse.builder()
                .username(cliente.getUsername())
                .password(cliente.getPassword())
                .cpf(cliente.getCpf())
                .status(cliente.getStatus())
                .build();
    }
}
