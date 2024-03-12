package com.bootcamp.ehs.controller;

import com.bootcamp.ehs.models.Bank;
import com.bootcamp.ehs.service.IBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BankController {

    private final IBankService bankService;

    // Metodo para registrar un banco realizando una veridiacion del codigo
    @PostMapping("/create")
    public Mono<Bank> registerBank(@RequestBody Bank bank){
        return bankService.saveBank(bank);
    }

    @GetMapping("/list")
    public Flux<Bank> getAll(){
        return bankService.getAllBanks();
    }

    // Obteniendo el banco por codigo de banco
    @GetMapping("/list/code/{codeBank}")
    public Mono<Bank> getBankByCode(@PathVariable("codeBank") String codeBank){
        return bankService.getBankByCode(codeBank);
    }

}
