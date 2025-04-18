package ch.planner.plannersvc.repository;

import ch.planner.plannersvc.model.EmployeeProjectMapping;
import io.quarkus.security.PermissionsAllowed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectMappingRepository extends JpaRepository<EmployeeProjectMapping, Long> {
    List<EmployeeProjectMapping> findEmployeeById();
    PermissionsAllowed.List<EmployeeProjectMapping> findProjectById();

}
