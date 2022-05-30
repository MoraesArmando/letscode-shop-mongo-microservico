package br.com.armando.cliente.model;

import br.com.armando.cliente.dto.ClienteRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
public class Cliente {

    @Id
    private String id;
    private String username;
    private String password;
    private String cpf;
    private Boolean status;


    public static Cliente converte(ClienteRequest clienteRquest) {
        return Cliente.builder()
                .username(clienteRquest.getUsername())
                .password(clienteRquest.getPassword())
                .cpf(clienteRquest.getCpf())
                .status(clienteRquest.getStatus())
                .build();
    }
}
