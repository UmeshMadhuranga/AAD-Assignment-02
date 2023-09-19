package lk.ijse.gdse.springmvc_with_gradle.service.util;

import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;
import lk.ijse.gdse.springmvc_with_gradle.entity.TechLead;
import lk.ijse.gdse.springmvc_with_gradle.exception.NotFoundException;
import lk.ijse.gdse.springmvc_with_gradle.repository.TechLeadRepo;
import lk.ijse.gdse.springmvc_with_gradle.service.TechLeadService;
import lk.ijse.gdse.springmvc_with_gradle.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    EntityConversion conversion;

    @Autowired
    TechLeadRepo repo;

    @Override
    public TechLeadDTO saveTL(TechLeadDTO techLeadDTO) {
        repo.save(conversion.getTLEntity(techLeadDTO));
        return techLeadDTO;
    }

    @Override
    public void updateTL(String id, TechLeadDTO techLeadDTO) {
        Optional<TechLead> techLead = repo.findById(id);
        if (!techLead.isPresent()) throw new NotFoundException("TechLead not found..");
        techLead.get().setName(techLeadDTO.getName());
        techLead.get().setEmail(techLeadDTO.getEmail());
        techLead.get().setProjects(techLeadDTO.getProjects());
    }

    @Override
    public void deleteTL(String id) {
        if (repo.existsById(id)) {
            throw new NotFoundException("TechLead not found..");
        }
        repo.deleteByTlId(id);
    }

    @Override
    public TechLeadDTO getTLById(String id) {
        TechLead techLead = repo.findByTlId(id);
        return conversion.getTLDto(techLead);
    }
}
