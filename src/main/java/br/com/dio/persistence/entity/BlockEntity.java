package br.com.dio.persistence.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BlockEntity {

    // Representa um registro de bloqueio de um card.
    private Long id;
    private OffsetDateTime blockedAt; // data do bloqueio
    private String blockReason; // motivo do bloqueio
    private OffsetDateTime unblockedAt; // data do desbloqueio
    private String unblockReason; // motivo do desbloqueio

}
