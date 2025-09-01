package br.com.dio.persistence.entity;

import lombok.Data;

@Data
public class CardEntity {

    // Representa um card dentro de uma coluna.
    private Long id;
    private String title;
    private String description;
    private BoardColumnEntity boardColumn = new BoardColumnEntity(); // coluna à qual pertence

}
