package lk.ijse.gdse.springmvc_with_gradle.repository;

import lk.ijse.gdse.springmvc_with_gradle.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {

    Project findByProjectId(String id);
    void deleteByProjectId(String id);

}
