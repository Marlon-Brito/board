package br.com.dio.exception;

// Exceção personalizada para tratar casos em que uma entidade não é encontrada no banco
// (exemplo: buscar um card inexistente).
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
