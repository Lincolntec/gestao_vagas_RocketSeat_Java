package br.com.lincolntec.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lincolntec.gestao_vagas.exceptions.JobNotFoundeException;
import br.com.lincolntec.gestao_vagas.exceptions.UserNotFoundException;
import br.com.lincolntec.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.lincolntec.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.lincolntec.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.lincolntec.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){

        this.candidateRepository.findById(idCandidate)
        .orElseThrow( () -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob)
        .orElseThrow( () -> {
            throw new JobNotFoundeException();
        });

        var applyjob = ApplyJobEntity.builder()
        .candidateId(idCandidate)
        .jobId(idJob).build();

        applyjob = applyJobRepository.save(applyjob);

        return applyjob;

    }
    

}
