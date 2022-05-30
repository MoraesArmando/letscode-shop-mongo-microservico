package br.com.armando.compra.dto;

import lombok.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

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

    public static ClienteResponse converte(Mono<ClienteResponse> mono){
        return ClienteResponse.builder()
                .cpf(Objects.requireNonNull(mono.block()).getCpf())
                .username(Objects.requireNonNull(mono.block()).getUsername())
                .status(Objects.requireNonNull(mono.block()).getStatus())
                .password(Objects.requireNonNull(mono.block()).getPassword())
                .build();
    }

}
