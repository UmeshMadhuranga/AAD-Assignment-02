package lk.ijse.gdse.springmvc_with_gradle.util;

import lk.ijse.gdse.springmvc_with_gradle.dto.ProjectDTO;
import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;
import lk.ijse.gdse.springmvc_with_gradle.entity.Project;
import lk.ijse.gdse.springmvc_with_gradle.entity.TechLead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityConversion {

    private final ModelMapper modelMapper;

    public EntityConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TechLead getTLEntity(TechLeadDTO techLeadDTO){
        return modelMapper.map(techLeadDTO, TechLead.class);
    }

    public TechLeadDTO getTLDto(TechLead techLead) {
        return modelMapper.map(techLead, TechLeadDTO.class);
    }

    public Project getProjectEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }

    public ProjectDTO getProjectDTO(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

}
