package lk.ijse.gdse.springmvc_with_gradle.service;

import lk.ijse.gdse.springmvc_with_gradle.dto.ProjectDTO;
import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;

public interface ProjectService {

    ProjectDTO saveProject(ProjectDTO projectDTO);
    void updateProject(String id, ProjectDTO projectDTO);
    void deleteProject(String id);
    ProjectDTO getProjectById(String id);

}
