package lk.ijse.gdse.springmvc_with_gradle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Project implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "tlId")
    private TechLead techLead;

}
