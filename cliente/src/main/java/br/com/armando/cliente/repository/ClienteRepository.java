package br.com.armando.cliente.repository;

import br.com.armando.cliente.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Mono<Cliente> findByCpf(String cpf);
}
