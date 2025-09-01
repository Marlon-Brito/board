package br.com.dio;

import br.com.dio.persistence.migration.MigrationStrategy;
import br.com.dio.ui.MainMenu;

import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

// Classe Main: ponto de entrada da aplicação.
public class Main {

    public static void main(String[] args) throws SQLException {
        // Executa migrações no banco de dados antes de iniciar.
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }
        // Inicia menu principal.
        new MainMenu().execute();
    }

}
