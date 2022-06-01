package br.com.armando.compravalidator.controller.impl;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.service.impl.CompraValidadorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/compra-validator")
@RequiredArgsConstructor
public class CompraValidatorControllerImpl {

    private final CompraValidadorServiceImpl compraValidadorService;

    @GetMapping
    public Flux<CompraResponse> listaCompras() {
        return compraValidadorService.listaTodasCompras();
    }

    @GetMapping("/{cpf}")
    public Flux<CompraResponse> obterPorCpf(@PathVariable String cpf) {
        return compraValidadorService.listaCpfPage(cpf);
    }

}
