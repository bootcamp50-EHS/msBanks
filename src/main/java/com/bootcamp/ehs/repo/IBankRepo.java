package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Bank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Interfaz para el repositorio de bancos.
 * Extiende ReactiveMongoRepository para operaciones CRUD.
 */
public interface IBankRepo extends ReactiveMongoRepository<Bank, String> {

    /**
     * Encuentra un banco por su código.
     *
     * @param codeBank El código del banco.
     * @return Un Mono con el Bank encontrado.
     */
    Mono<Bank> findByCodeBank(String codeBank);
}
