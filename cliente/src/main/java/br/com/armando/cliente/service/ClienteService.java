package br.com.armando.cliente.service;

import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

   ClienteResponse criaCliente(ClienteRequest clienteRquest);

   Page<ClienteResponse> listaClientes(Pageable pageable);

   ClienteResponse obterPorId(String id);

   ClienteResponse atualizaCliente(ClienteRequest clienteRequest);

   ClienteResponse deletacliente(String id);
}
