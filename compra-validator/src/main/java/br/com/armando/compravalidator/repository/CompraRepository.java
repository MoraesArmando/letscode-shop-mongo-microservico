package br.com.armando.compravalidator.repository;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends MongoRepository<Compra, String> {
    CompraResponse findByCpf(String cpf);
}
