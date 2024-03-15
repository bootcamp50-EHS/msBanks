package com.bootcamp.ehs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un banco con un id, código y nombre.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "banks")
public class Bank {

    /**
     * El ID del banco.
     */
    @Id
    private String id;

    /**
     * El código del banco.
     */
    @NonNull
    private String codeBank;

    /**
     * El nombre del banco.
     */
    @NonNull
    private String nameBank;
}
