package lk.ijse.gdse.springmvc_with_gradle.dto;

import lk.ijse.gdse.springmvc_with_gradle.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProjectDTO {

    private String projectId;
    private String name;
    private Date endDate;
    private TechLead techLead;

}
