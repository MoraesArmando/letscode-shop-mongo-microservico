package br.com.armando.compra.repository;

import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends MongoRepository<Compra, String> {
    Page<Compra> findByCpf(String cpf, Pageable pageable);
}
