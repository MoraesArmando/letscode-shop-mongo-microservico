package br.com.armando.cliente.service;

import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {

   Mono<ClienteResponse> criaCliente(ClienteRequest clienteRquest);

   Flux<ClienteResponse> listaClientes();

   Mono<ClienteResponse> obterPorId(String id);

    Mono<ClienteResponse> obterPorCpf(String cpf);
}
