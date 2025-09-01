package br.com.dio.persistence.entity;

import java.util.stream.Stream;

public enum BoardColumnKindEnum {

    INITIAL, FINAL, CANCEL, PENDING; // Tipos possíveis de colunas

    // Busca um tipo de coluna pelo nome (string), lança exceção se não existir.
    public static BoardColumnKindEnum findByName(final String name){
        return Stream.of(BoardColumnKindEnum.values())
                .filter(b -> b.name().equals(name))
                .findFirst().orElseThrow();
    }

}
