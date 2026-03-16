package com.civic.smartcity.repository;

import com.civic.smartcity.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

    List<Grievance> findByCitizenId(Long citizenId);

    List<Grievance> findByOfficerId(Long officerId);
}