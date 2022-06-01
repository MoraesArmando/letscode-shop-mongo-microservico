package br.com.armando.compravalidator.repository;

import br.com.armando.compravalidator.model.Compra;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CompraValidatorRepository extends ReactiveMongoRepository<Compra, String> {
    Flux<Compra> findByCpf(String cpf);
}
