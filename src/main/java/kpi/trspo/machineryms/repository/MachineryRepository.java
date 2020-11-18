package kpi.trspo.machineryms.repository;

import kpi.trspo.machineryms.model.Machinery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MachineryRepository extends JpaRepository<Machinery, UUID> {
}

