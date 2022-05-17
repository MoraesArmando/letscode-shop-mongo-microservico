package br.com.armando.produto.repository;

import br.com.armando.produto.model.Produto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProdutoRepository extends ReactiveMongoRepository<Produto, String> {

    Mono<Produto> findByCodigo(String codigo);
}
