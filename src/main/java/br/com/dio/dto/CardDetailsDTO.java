package br.com.dio.dto;

import java.time.OffsetDateTime;

// DTO que representa os detalhes de um card dentro de uma coluna.
// Inclui informações como título, descrição, se está bloqueado, motivo do bloqueio,
// quantidade de bloqueios, além do id e nome da coluna a que pertence.
public record CardDetailsDTO(Long id,
                             String title,
                             String description,
                             boolean blocked,
                             OffsetDateTime blockedAt,
                             String blockReason,
                             int blocksAmount,
                             Long columnId,
                             String columnName
) {
}
