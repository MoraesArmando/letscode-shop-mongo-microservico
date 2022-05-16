package br.com.armando.cliente.controller;


import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import br.com.armando.cliente.service.impl.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl;

    @PostMapping
    public ClienteResponse criaCliente(@RequestBody ClienteRequest clienteRequest) {
        return clienteServiceImpl.criaCliente(clienteRequest);
    }

    @GetMapping
    public Page<ClienteResponse> listaClientes(@PageableDefault Pageable pageable) {
        return clienteServiceImpl.listaClientes(pageable);
    }

    @GetMapping("/")
    public ClienteResponse obterPorId(@RequestParam(name = "id") String id) {
        return clienteServiceImpl.obterPorId(id);
    }

    @GetMapping("/{cpf}")
    public ClienteResponse obterPorCpf(@PathVariable String cpf) {
        return clienteServiceImpl.obterPorCpf(cpf);
    }

    @PutMapping
    public ClienteResponse atualizaCliente(@RequestBody ClienteRequest clienteRequest) {
        return clienteServiceImpl.atualizaCliente(clienteRequest);
    }

    @DeleteMapping
    public ClienteResponse deletaCliete(@RequestParam(name = "id") String id) {
        return clienteServiceImpl.deletacliente(id);
    }
}
