package br.com.armando.compra.controller;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.service.impl.CompraServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compra")
public class CompraController {

    private final CompraServiceImpl compraService;

    @GetMapping
    public Page<CompraResponse> listaCompras(@PageableDefault Pageable pageable){
        return compraService.listaTodasCompras(pageable);
    }

    @GetMapping("/")
    public Page<CompraResponse> obterPorCpf(@RequestParam(name = "cpf") String cpf, @PageableDefault Pageable pageable){
        return compraService.listaCpfPage(cpf, pageable);
    }

    @PostMapping
    public CompraResponse criaCompra(@RequestBody CompraRequest compraRequest){
        return compraService.criarCompra(compraRequest);
    }

}
