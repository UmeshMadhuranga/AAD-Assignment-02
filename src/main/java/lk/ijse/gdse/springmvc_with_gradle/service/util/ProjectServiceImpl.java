package lk.ijse.gdse.springmvc_with_gradle.service.util;

import lk.ijse.gdse.springmvc_with_gradle.dto.ProjectDTO;
import lk.ijse.gdse.springmvc_with_gradle.entity.Project;
import lk.ijse.gdse.springmvc_with_gradle.exception.NotFoundException;
import lk.ijse.gdse.springmvc_with_gradle.repository.ProjectRepo;
import lk.ijse.gdse.springmvc_with_gradle.service.ProjectService;
import lk.ijse.gdse.springmvc_with_gradle.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepo repo;

    @Autowired
    EntityConversion conversion;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        repo.save(conversion.getProjectEntity(projectDTO));
        return projectDTO;
    }

    @Override
    public void updateProject(String id, ProjectDTO projectDTO) {
        Optional<Project> project = repo.findById(id);
        if (!project.isPresent()) throw new NotFoundException("Project not found..");
        project.get().setName(projectDTO.getName());
        project.get().setEndDate(projectDTO.getEndDate());
        project.get().setTechLead(projectDTO.getTechLead());
    }

    @Override
    public void deleteProject(String id) {
        if (!repo.existsById(id)) throw new NotFoundException("Project not found..");
        repo.deleteByProjectId(id);
    }

    @Override
    public ProjectDTO getProjectById(String id) {
        Project project = repo.findByProjectId(id);
        return conversion.getProjectDTO(project);
    }
}
