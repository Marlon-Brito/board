package br.com.dio.exception;

// Exceção personalizada lançada quando um card está bloqueado
// e alguma operação não pode ser concluída.
public class CardBlockedException extends RuntimeException{

    public CardBlockedException(final String message) {
        super(message);
    }
}
