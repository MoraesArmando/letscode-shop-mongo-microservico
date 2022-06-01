package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.ClienteResponse;
import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.dto.ProdutoCompraResponse;
import br.com.armando.compravalidator.dto.ProdutoResponse;
import br.com.armando.compravalidator.redis.CacheClienteService;
import br.com.armando.compravalidator.repository.CompraValidatorRepository;
import br.com.armando.compravalidator.service.CompraValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CompraValidadorServiceImpl implements CompraValidatorService {

    private final ClienteServiceImpl clienteService;
    private final ProdutoServiceImpl produtoService;
    private final CacheClienteService cacheClienteService;
    private final CompraValidatorRepository compraValidatorRepository;



    public CompraResponse validationCompra(CompraResponse compraResponse){
        getClient(compraResponse);

        Float valorTotal = 0F;
        for (ProdutoCompraResponse produtoCompraResponse : compraResponse.getProdutoCompra()) {
            ProdutoResponse produto = produtoService.getProduto(produtoCompraResponse.getCodigoProduto());
            if (produto == null) {
                throw new RuntimeException("Produto invalido.");
            }
            valorTotal += produto.getPreco();
        }
        compraResponse.setValorTotal(valorTotal);
        compraResponse.setStatus("PROCESSADA");

        return compraResponse;
    }

    private void getClient(CompraResponse compraResponse) {
        ClienteResponse cliente = cacheClienteService.get(compraResponse.getCpf());
        if (cliente == null) {
            cliente = clienteService.getCliente(compraResponse.getCpf());
            if (cliente == null && cliente.getCpf() != null) {
                throw new RuntimeException("Client not found.");
            }
            cacheClienteService.salvar(cliente);
        }
    }

    @Override
    public Flux<CompraResponse> listaCpfPage(String cpf) {
        return compraValidatorRepository.findByCpf(cpf).map(CompraResponse::convert);
    }

    @Override
    public Flux<CompraResponse> listaTodasCompras() {
        return compraValidatorRepository.findAll().map(CompraResponse::convert);
    }



}
