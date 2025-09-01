package br.com.dio.persistence.converter;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.nonNull;
import static lombok.AccessLevel.PRIVATE;

// Classe utilitária não pode ser instanciada.
@NoArgsConstructor(access = PRIVATE)
public final class OffsetDateTimeConverter {

    // Converte um Timestamp do banco para OffsetDateTime no fuso UTC.
    public static OffsetDateTime toOffsetDateTime(final Timestamp value){
        return nonNull(value) ? OffsetDateTime.ofInstant(value.toInstant(), UTC) : null;
    }

    // Converte um OffsetDateTime em UTC para Timestamp, usado em inserções/atualizações no banco.
    public static Timestamp toTimestamp(final OffsetDateTime value){
        return nonNull(value) ? Timestamp.valueOf(value.atZoneSameInstant(UTC).toLocalDateTime()) : null;
    }

}
