package com.bootcamp.ehs.service.impl;

import com.bootcamp.ehs.models.Bank;
import com.bootcamp.ehs.repo.IBankRepo;
import com.bootcamp.ehs.service.IBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements IBankService {

    /**
     * Repositorio para operaciones relacionadas con bancos.
     */
    private final IBankRepo bankRepo;

    /**
     * Guarda un banco en la base de datos.
     *
     * @param bank El banco a guardar.
     * @return El banco guardado.
     */
    @Override
    public Mono<Bank> saveBank(final Bank bank) {
        return bankRepo.findByCodeBank(bank.getCodeBank())
                .doOnNext(bankExist -> log.info("El Banco ya existe"))
                .flatMap(Mono::just)
                .switchIfEmpty(bankRepo.save(bank));
    }

    /**
     * Obtiene un banco por su código.
     *
     * @param codeBank El codigo del banco a consultar
     * @return El banco consultado
     */
    @Override
    public Mono<Bank> getBankByCode(final String codeBank) {
        return bankRepo.findByCodeBank(codeBank);
    }

    /**
     * Obtiene la lista de bancos.
     *
     * @return Una lista de bancos.
     */
    @Override
    public Flux<Bank> getAllBanks() {
        return bankRepo.findAll();
    }
}
