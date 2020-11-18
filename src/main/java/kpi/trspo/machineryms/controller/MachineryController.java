package kpi.trspo.machineryms.controller;

import javassist.NotFoundException;
import kpi.trspo.machineryms.model.Machinery;
import kpi.trspo.machineryms.service.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/machinery")
public class MachineryController {
    private final MachineryService machineryService;

    @Autowired
    public MachineryController(MachineryService machineryService){
        this.machineryService = machineryService;
    }

    @GetMapping
    public List<Machinery> getMachinery(){ return machineryService.getAll();}

    @GetMapping(path = "{id}")
    public Machinery getMachineryTypeById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return machineryService.getById(id);
    }

    @PostMapping
    public Machinery addMachinery(@RequestBody Machinery addedMachinery)
    {
        return machineryService.create(addedMachinery);
    }

    @PutMapping(path = "{id}")
    public void changeMachineryType(@PathVariable("id") UUID id, @RequestBody Machinery machineryDetails)
            throws NotFoundException
    {
        machineryService.update(id, machineryDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMachineryTypeById(@PathVariable("id") UUID id) throws NotFoundException
    {
        machineryService.delete(id);
    }
}
