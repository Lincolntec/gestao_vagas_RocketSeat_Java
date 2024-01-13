package br.com.lincolntec.gestao_vagas.exceptions;

public class JobNotFoundeException extends RuntimeException {

    public JobNotFoundeException() {
        super("Job not found");
    }
    
    
}
