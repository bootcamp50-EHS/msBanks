package com.bootcamp.ehs.service;

import com.bootcamp.ehs.models.Bank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankService {

    /**
     * Guarda la información de un banco en la base de datos.
     *
     * @param bank El objeto Bank con la información del banco a guardar.
     * @return Un Mono que emite el Bank guardado.
     */
    Mono<Bank> saveBank(Bank bank);

    /**
     * Obtiene la información de un banco por su código.
     *
     * @param codeBank El código del banco a buscar.
     * @return Un Mono que emite el Bank encontrado.
     */
    Mono<Bank> getBankByCode(String codeBank);

    /**
     * Obtiene la información de todos los bancos.
     *
     * @return Un Flux que emite todos los Banks encontrados.
     */
    Flux<Bank> getAllBanks();
}
