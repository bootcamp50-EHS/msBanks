package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Bank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IBankRepo extends ReactiveMongoRepository<Bank, String> {

    Mono<Bank> findByCodeBank(String codeBank);
}
