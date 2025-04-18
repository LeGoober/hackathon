package ch.planner.plannersvc.model;

import ch.planner.plannersvc.model.base.CompanyAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
public class Employee extends CompanyAwareBaseEntity {
    @Id
    private String id; // Inherited from BaseEntity

    @Column(name = "name", nullable = false)
    @Setter
    private String name;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "lang", nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private Language lang;

    @Column(name = "well_being_score")
    private double wellBeingScore;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeProjectMapping> projectMappings = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();
}