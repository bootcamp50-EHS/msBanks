package com.bootcamp.ehs.service;

import com.bootcamp.ehs.models.Bank;
import reactor.core.publisher.Mono;

public interface IBankService {

    Mono<Bank> saveBank(Bank bank);

    Mono<Bank> getBankByCode(String codeBank);
}
