package lk.ijse.gdse.springmvc_with_gradle.util;

import lk.ijse.gdse.springmvc_with_gradle.dto.TechLeadDTO;
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

}
