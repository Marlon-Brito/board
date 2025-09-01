package br.com.dio.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardColumnEntity {

    // Representa uma coluna dentro de um board.
    private Long id;
    private String name;
    private int order;
    private BoardColumnKindEnum kind; // tipo da coluna (INICIAL, FINAL, etc.)
    private BoardEntity board = new BoardEntity(); // referência ao board
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CardEntity> cards = new ArrayList<>(); // cards dentro da coluna

}
