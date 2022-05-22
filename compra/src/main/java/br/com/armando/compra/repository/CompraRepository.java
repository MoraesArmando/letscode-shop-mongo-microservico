package br.com.armando.compra.repository;

import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.model.Compra;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CompraRepository extends ReactiveMongoRepository<Compra, String> {
    Mono<CompraResponse> findByCpf(String cpf);
}
