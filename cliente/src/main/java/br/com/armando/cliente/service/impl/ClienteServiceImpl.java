package br.com.armando.cliente.service.impl;

import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import br.com.armando.cliente.model.Cliente;
import br.com.armando.cliente.repository.ClienteRepository;
import br.com.armando.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse criaCliente(ClienteRequest clienteRquest) {
        Cliente cliente = Cliente.converte(clienteRquest);
        return ClienteResponse.converte(clienteRepository.save(cliente));
    }

    public Page<ClienteResponse> listaClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable).map(ClienteResponse::converte);
    }

    public ClienteResponse obterPorId(String id) {
        return ClienteResponse.converte(clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encotrado")));
    }

    public ClienteResponse atualizaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.findByCpf(clienteRequest.getCpf());
        cliente.setUsername(clienteRequest.getUsername());
        cliente.setPassword(cliente.getPassword());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setStatus(clienteRequest.getStatus());

        return ClienteResponse.converte((cliente));
    }

    public ClienteResponse deletacliente(String id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ClienteResponse.converte((cliente));
    }

}
