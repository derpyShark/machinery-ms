package kpi.trspo.machineryms.service;

import javassist.NotFoundException;
import kpi.trspo.machineryms.model.Machinery;

import java.util.List;
import java.util.UUID;

public interface MachineryService {
    List<Machinery> getAll();
    Machinery getById(UUID machineryId) throws NotFoundException;
    Machinery create(Machinery machineryObject);
    Machinery update(UUID machineryId, Machinery machineryDetails) throws NotFoundException;
    void delete(UUID machineryId) throws NotFoundException;
}
