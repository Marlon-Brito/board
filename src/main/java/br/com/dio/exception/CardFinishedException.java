package br.com.dio.exception;

// Exceção personalizada lançada quando um card já foi finalizado
// e alguma operação não pode ser concluída.
public class CardFinishedException extends RuntimeException{

    public CardFinishedException(final String message) {
        super(message);
    }
}
