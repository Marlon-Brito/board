package br.com.dio.persistence.dao;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;

import static br.com.dio.persistence.converter.OffsetDateTimeConverter.toTimestamp;

@AllArgsConstructor
public class BlockDAO {

    private final Connection connection;

    // Insere um registro de bloqueio de um card, informando o motivo e a data/hora atual.
    public void block(final String reason, final Long cardId) throws SQLException {
        var sql = "INSERT INTO BLOCKS (blocked_at, block_reason, card_id) VALUES (?, ?, ?);";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason); // motivo do bloqueio
            statement.setLong(i, cardId); // id do card
            statement.executeUpdate();
        }
    }

    // Atualiza o registro de bloqueio, adicionando data/hora e motivo do desbloqueio.
    public void unblock(final String reason, final Long cardId) throws SQLException{
        var sql = "UPDATE BLOCKS SET unblocked_at = ?, unblock_reason = ? WHERE card_id = ? AND unblock_reason IS NULL;";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason); // motivo do desbloqueio
            statement.setLong(i, cardId); // id do card
            statement.executeUpdate();
        }
    }

}
