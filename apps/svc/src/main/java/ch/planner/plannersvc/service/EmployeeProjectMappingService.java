package ch.planner.plannersvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.planner.plannersvc.model.EmployeeProjectMapping;
import ch.planner.plannersvc.repository.EmployeeProjectMappingRepository;

@Service
public class EmployeeProjectMappingService {
    @Autowired
    private EmployeeProjectMappingRepository repository;

    public List<EmployeeProjectMapping> getAllMappings(){
    return repository.findAll();
    }

    public EmployeeProjectMapping saveMapping(EmployeeProjectMapping mapping){
        return repository.save(mapping);
    }

    public void deleteMapping(Long id){
        repository.deleteById(id);
    }
}
