package br.com.lincolntec.gestao_vagas.modules.company.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lincolntec.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.lincolntec.gestao_vagas.modules.company.entities.JobEntity;
import br.com.lincolntec.gestao_vagas.modules.company.useCase.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
        var companyID = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder().benefits(createJobDTO.getBenefits())
        .description(createJobDTO.getBenefits())
        .companyId(UUID.fromString(companyID.toString()))
        .level(createJobDTO.getLevel())
        .build();
       
        return this.createJobUseCase.execute(jobEntity);
    }
    
}
