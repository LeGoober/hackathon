package main.java.ch.planner.plannersvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectMapping {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

}
