package br.com.dio.persistence.config;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

// Impede instância da classe (somente métodos estáticos).
@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    // Cria e retorna uma conexão com o banco MySQL "board"
    // Usuário e senha também são "board". O autoCommit é desativado para controle manual de transações.
    public static Connection getConnection() throws SQLException {
        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "board";
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }

}
