package br.com.lincolntec.gestao_vagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lincolntec.gestao_vagas.modules.company.entities.JobEntity;
import br.com.lincolntec.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
       return this.jobRepository.save(jobEntity);
    }
    
}
