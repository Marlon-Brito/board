package br.com.dio.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class MigrationStrategy {

    private final Connection connection;

    // Executa as migrações do banco de dados utilizando Liquibase.
    // Redireciona a saída do console para o arquivo "liquibase.log".
    public void executeMigration(){
        var originalOut = System.out; // guarda saída padrão
        var originalErr = System.err; // guarda saída de erro padrão
        try(var fos = new FileOutputStream("liquibase.log")){
            System.setOut(new PrintStream(fos)); // redireciona saída para arquivo
            System.setErr(new PrintStream(fos));
            try(
                    var connection = getConnection(); // abre conexão
                    var jdbcConnection = new JdbcConnection(connection); // cria conexão JDBC para Liquibase
            ){
                var liquibase = new Liquibase(
                        "/db/changelog/db.changelog-master.yml", // changelog de migração
                        new ClassLoaderResourceAccessor(),
                        jdbcConnection);
                liquibase.update(); // executa as migrações
            } catch (SQLException | LiquibaseException e) {
                e.printStackTrace();
                System.setErr(originalErr);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            // restaura saídas padrão
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

}
