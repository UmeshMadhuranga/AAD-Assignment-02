package lk.ijse.gdse.springmvc_with_gradle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class TechLead implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String tlId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "techLead", cascade = CascadeType.ALL)
    private List<Project> projects;

}
