package com.bootcamp.ehs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "banks")
public class Bank {

    @Id
    private String id;
    @NonNull
    private String codeBank;
    @NonNull
    private String nameBank;
}
