package br.com.dio.dto;

import br.com.dio.persistence.entity.BoardColumnKindEnum;

// DTO que representa informações resumidas de uma coluna.
// Usado para cenários onde só é necessário id, ordem e tipo.
public record BoardColumnInfoDTO(Long id, int order, BoardColumnKindEnum kind) {
}
