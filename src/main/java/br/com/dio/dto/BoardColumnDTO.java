package br.com.dio.dto;

import br.com.dio.persistence.entity.BoardColumnKindEnum;

// DTO (Data Transfer Object) que representa uma coluna de um quadro (Board).
// Contém o id, nome, tipo da coluna (enum) e quantidade de cards nela.
public record BoardColumnDTO(Long id,
                             String name,
                             BoardColumnKindEnum kind,
                             int cardsAmount) {
}
