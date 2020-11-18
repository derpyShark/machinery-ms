package kpi.trspo.machineryms.service;

import javassist.NotFoundException;
import kpi.trspo.machineryms.model.Machinery;
import kpi.trspo.machineryms.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MachineryServiceImpl implements MachineryService {

    @Autowired
    private MachineryRepository machineryRepository;

    @Override
    public List<Machinery> getAll() {
        return machineryRepository.findAll();
    }

    @Override
    public Machinery getById(UUID machineryId) throws NotFoundException {
        Optional<Machinery> machineryMaybe = machineryRepository.findById(machineryId);
        if(machineryMaybe.isPresent()){
            return machineryMaybe.get();
        }
        else
            throw new NotFoundException("No machineryType with such an Id: " + machineryId);
    }

    @Override
    public Machinery update(UUID machineryId, Machinery machineryDetails) throws NotFoundException {
        Machinery oldMachinery = getById(machineryId);
        oldMachinery.setOperator(machineryDetails.getOperator());
        oldMachinery.setMachineryType(machineryDetails.getMachineryType());
        return machineryRepository.save(oldMachinery);
    }

    @Override
    public Machinery create(Machinery machineryObject) {
        return machineryRepository.save(machineryObject);
    }

    @Override
    public void delete(UUID machineryTypeId) throws NotFoundException{
        machineryRepository.delete(getById(machineryTypeId));
    }
}

