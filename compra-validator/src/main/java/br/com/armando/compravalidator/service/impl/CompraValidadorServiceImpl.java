package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.ClienteResponse;
import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.dto.ProdutoResponse;
import br.com.armando.compravalidator.service.impl.redis.CacheClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraValidadorServiceImpl {

    private final ClienteServiceImpl clienteService;
    private final ProdutoServiceImpl produtoService;


    private final CacheClienteService cacheClienteService;


    public CompraResponse validationCompra(CompraResponse compraResponse){

        getClient(compraResponse);
        Float valorTotal = 0F;

        for (String produto : compraResponse.getCpf()) {
            ProdutoResponse produtoDTO = ProdutoService.getProduto(produto);
            if (produtoDTO == null) {
                throw new RuntimeException("Produto invalido.");
            }
            valorTotal += produtoDTO.getPreco();
        }
        compraDTO.setValorTotal(valorTotal);
        compraDTO.setStatus("PROCESSADA");


    }

    private void getClient(CompraResponse compraResponse) {
        ClienteResponse cliente = cacheClienteService.get(compraResponse.getCpf());
        if (cliente == null) {
            cliente = ClienteServiceImpl.getCliente(compraResponse.getCpf());
            if (cliente == null && cliente.getCpf() != null) {
                throw new RuntimeException("Client not found.");
            }
            cacheClienteService.salvar(cliente);
        }

        Long fim = System.currentTimeMillis();
    }
}
