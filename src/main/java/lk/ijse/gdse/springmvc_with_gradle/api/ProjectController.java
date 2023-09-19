package lk.ijse.gdse.springmvc_with_gradle.api;

import lk.ijse.gdse.springmvc_with_gradle.dto.ProjectDTO;
import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;
import lk.ijse.gdse.springmvc_with_gradle.exception.InvalidException;
import lk.ijse.gdse.springmvc_with_gradle.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

//    @Autowired
//    ProjectService service;
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ProjectDTO saveProject(ProjectDTO projectDTO) {
//
//        if(projectDTO.getName() == null || !projectDTO.getName().matches("[A-Za-z ]+")){
//            throw new InvalidException("Invalid Name");
//        } else if (projectDTO.getEndDate() == null) {
//            throw new InvalidException("Invalid Date");
//        } else if (projectDTO.getTechLead() == null) {
//            throw new InvalidException("Invalid Input");
//        }
//
//        service.saveProject(projectDTO);
//        return projectDTO;
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PatchMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void updateProject(@PathVariable("id") String id, @RequestBody ProjectDTO projectDTO) {
//
//        if(projectDTO.getName() == null || !projectDTO.getName().matches("[A-Za-z ]+")){
//            throw new InvalidException("Invalid Name");
//        } else if (projectDTO.getEndDate() == null) {
//            throw new InvalidException("Invalid Date");
//        } else if (projectDTO.getTechLead() == null) {
//            throw new InvalidException("Invalid Input");
//        }
//
//        service.updateProject(id, projectDTO);
//
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(path = "{id}")
//    public void deleteProject(@PathVariable String id) {
//        service.deleteProject(id);
//    }
//
//    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ProjectDTO getTLById(@PathVariable String id) {
//        if(!id.matches("[A-Fa-f0-9\\-]{36}")) throw new InvalidException("Id is invalid");
//        return service.getProjectById(id);
//    }

}
