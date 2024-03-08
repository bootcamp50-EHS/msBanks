package com.bootcamp.ehs.service.impl;

import com.bootcamp.ehs.models.Bank;
import com.bootcamp.ehs.repo.IBankRepo;
import com.bootcamp.ehs.service.IBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements IBankService {

    private final IBankRepo bankRepo;

    @Override
    public Mono<Bank> saveBank(Bank bank) {
        return bankRepo.findByCodeBank(bank.getCodeBank())
                .doOnNext(bankExist -> log.info("El Banco ya existe"))
                .flatMap(Mono::just)
                .switchIfEmpty(bankRepo.save(bank));
    }

    @Override
    public Mono<Bank> getBankByCode(String codeBank) {
        return bankRepo.findByCodeBank(codeBank);
    }
}
