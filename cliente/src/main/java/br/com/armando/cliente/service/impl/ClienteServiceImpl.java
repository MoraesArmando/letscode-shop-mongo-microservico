package br.com.armando.cliente.service.impl;

import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import br.com.armando.cliente.model.Cliente;
import br.com.armando.cliente.repository.ClienteRepository;
import br.com.armando.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public Mono<ClienteResponse> criaCliente(ClienteRequest clienteRquest) {
        Cliente cliente = Cliente.converte(clienteRquest);
        Mono<Cliente> clienteMono = clienteRepository.insert(cliente);
        return clienteMono.map(ClienteResponse::converte);
    }

    public Flux<ClienteResponse> listaClientes() {
        return clienteRepository.findAll().map(ClienteResponse::converte);
    }

    public Mono<ClienteResponse> obterPorId(String id) {
        Mono<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ClienteResponse::converte);
    }

    @Override
    public Mono<ClienteResponse> obterPorCpf(String cpf) {
        return (clienteRepository.findByCpf(cpf)).map(ClienteResponse::converte);
    }

}
