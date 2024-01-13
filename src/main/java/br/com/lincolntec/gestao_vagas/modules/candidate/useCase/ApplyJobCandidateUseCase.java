package br.com.lincolntec.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lincolntec.gestao_vagas.exceptions.JobNotFoundeException;
import br.com.lincolntec.gestao_vagas.exceptions.UserNotFoundException;
import br.com.lincolntec.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.lincolntec.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public void execute(UUID idCandidate, UUID idJob){

        this.candidateRepository.findById(idCandidate)
        .orElseThrow( () -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob)
        .orElseThrow( () -> {
            throw new JobNotFoundeException();
        });

    }
    

}
