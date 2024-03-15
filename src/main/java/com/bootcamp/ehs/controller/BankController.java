package com.bootcamp.ehs.controller;

import com.bootcamp.ehs.models.Bank;
import com.bootcamp.ehs.service.IBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public final class BankController {
    /**
     * Servicio para operaciones bancarias.
     */
    private final IBankService bankService;

    /**
     * Registra un nuevo banco.
     *
     * @param bank El banco a registrar.
     * @return El banco registrado.
     */
    @PostMapping("/create")
    public Mono<Bank> registerBank(@RequestBody final Bank bank) {
        return bankService.saveBank(bank);
    }
    /**
     * Obtiene todos los bancos.
     * @return Lista de bancos
     */
    @GetMapping("/list")
    public Flux<Bank> getAll() {
        return bankService.getAllBanks();
    }


    /**
     * Obtiene un banco por su código.
     *
     * @param codeBank El código del banco.
     * @return El banco correspondiente al código.
     */
    @GetMapping("/list/code/{codeBank}")
    public Mono<Bank> getBankByCode(
            @PathVariable("codeBank") final String codeBank) {
        return bankService.getBankByCode(codeBank);
    }

}
