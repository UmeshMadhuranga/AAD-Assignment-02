package lk.ijse.gdse.springmvc_with_gradle.api;

import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;
import lk.ijse.gdse.springmvc_with_gradle.exception.InvalidException;
import lk.ijse.gdse.springmvc_with_gradle.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/techLead")
public class TechLeadController {

    @Autowired
    TechLeadService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TechLeadDTO saveTL(TechLeadDTO techLeadDTO) {

        if(techLeadDTO.getName() == null || !techLeadDTO.getName().matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (techLeadDTO.getEmail() == null) {
            throw new InvalidException("Invalid Email");
        } else if (techLeadDTO.getProjects() == null) {
            throw new InvalidException("Invalid Input");
        }

        service.saveTL(techLeadDTO);
        return techLeadDTO;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTL(@PathVariable("id") String id, @RequestBody TechLeadDTO techLeadDTO) {

        if(techLeadDTO.getName() == null || !techLeadDTO.getName().matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (techLeadDTO.getEmail() == null) {
            throw new InvalidException("Invalid Email");
        } else if (techLeadDTO.getProjects() == null) {
            throw new InvalidException("Invalid Input");
        }

        service.updateTL(id, techLeadDTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteTL(@PathVariable String id) {
        service.deleteTL(id);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TechLeadDTO getTLById(@PathVariable String id) {
        if(!id.matches("[A-Fa-f0-9\\-]{36}")) throw new InvalidException("Id is invalid");
        return service.getTLById(id);
    }

}
