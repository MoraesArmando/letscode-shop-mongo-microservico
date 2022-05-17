package br.com.armando.compra.controller;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.service.impl.CompraServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compra")
public class CompraController {

    private final CompraServiceImpl compraService;

    @GetMapping
    public Flux<CompraResponse> listaCompras(){
        return compraService.listaTodasCompras();
    }

    @GetMapping("/")
    public Mono<CompraResponse> obterPorCpf(@RequestParam(name = "cpf") String cpf){
        return compraService.listaCpfPage(cpf);
    }

    @PostMapping
    public Mono<CompraResponse> criaCompra(@RequestBody CompraRequest compraRequest){
        return compraService.criarCompra(compraRequest);
    }

}
