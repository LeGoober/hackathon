
package ch.planner.plannersvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.planner.plannersvc.model.EmployeeProjectMapping;
import ch.planner.plannersvc.service.EmployeeProjectMappingService;
import ch.planner.plannersvc.service.EmployeeService;
import ch.planner.plannersvc.service.ProjectService;


@RestController
@RequestMapping("/api/project_mappings")
public class EmployeeProjectMappingController {
    @Autowired
    private EmployeeProjectMappingService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;


    @GetMapping
    public List<EmployeeProjectMapping> getAllProjectMappings(){
        return service.getAllMappings();
    }

    @PostMapping
    public EmployeeProjectMapping createProjectMapping(@RequestBody EmployeeProjectMapping mapping){
        return service.saveMapping(mapping);
    }

    @DeleteMapping("{/id}")
    public void deleteProject(@PathVariable Long id){
        service.deleteMapping(id);
    }

}
