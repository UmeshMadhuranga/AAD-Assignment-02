package lk.ijse.gdse.springmvc_with_gradle.service;

import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;

public interface TechLeadService {

    TechLeadDTO saveTL(TechLeadDTO techLeadDTO);
    void updateTL(String id, TechLeadDTO techLeadDTO);
    void deleteTL(String id);
    TechLeadDTO getTLById(String id);

}
