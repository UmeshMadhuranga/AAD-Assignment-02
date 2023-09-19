package lk.ijse.gdse.springmvc_with_gradle.repository;

import lk.ijse.gdse.springmvc_with_gradle.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepo extends JpaRepository<TechLead, String> {

    TechLead findByTlId(String id);
    void deleteByTlId(String id);

}
