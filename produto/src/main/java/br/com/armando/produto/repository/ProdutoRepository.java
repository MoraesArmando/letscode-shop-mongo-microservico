package br.com.armando.produto.repository;

import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Produto findByCodigo(String codigo);
}
