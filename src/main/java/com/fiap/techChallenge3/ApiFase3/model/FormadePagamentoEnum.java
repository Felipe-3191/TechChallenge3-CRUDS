package com.fiap.techChallenge3.ApiFase3.model;

import java.util.Arrays;
import java.util.Optional;

public enum FormadePagamentoEnum {

    DEBITO(1L),
    CREDITO(2L),
    PIX(3L);

    private Long id;

     FormadePagamentoEnum(Long id){
        this.id = id;
    }

    public Long getId() {
         return this.id;
    }

    public static Optional<FormadePagamentoEnum> fromLong(Long id) {
         return Arrays.stream(FormadePagamentoEnum.values()).filter( f -> f.getId().equals(id)).findFirst();
    }

}



