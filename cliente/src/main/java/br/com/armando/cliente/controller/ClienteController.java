package br.com.armando.cliente.controller;


import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import br.com.armando.cliente.service.impl.ClienteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl;

    @PostMapping
    public Mono<ClienteResponse> criaCliente(@RequestBody ClienteRequest clienteRequest) {
        return clienteServiceImpl.criaCliente(clienteRequest);
    }

    @GetMapping
    public Flux<ClienteResponse> listaClientes() {
        return clienteServiceImpl.listaClientes();
    }

    @GetMapping("/")
    public Mono<ClienteResponse> obterPorId(@RequestParam(name = "id") String id) {
        return clienteServiceImpl.obterPorId(id);
    }

    @GetMapping("/{cpf}")
    public Mono<ClienteResponse> obterPorCpf(@PathVariable String cpf) {
        return clienteServiceImpl.obterPorCpf(cpf);
    }

}
