package lk.ijse.gdse.springmvc_with_gradle.dto;

import jakarta.persistence.*;
import lk.ijse.gdse.springmvc_with_gradle.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TechLeadDTO {

    private String tlId;
    private String name;
    private String email;
    private List<Project> projects;

}
