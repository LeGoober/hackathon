import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EmployeeDto, ProjectDto } from "src/generated";

@Injectable({ providedIn: 'root' })
export class PlannerService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {}

  getMappings() {
    return this.http.get<EmployeeProjectMapping[]>(`${this.apiUrl}/mappings`);
  }

  createMapping(mapping: EmployeeProjectMapping) {
    return this.http.post<EmployeeProjectMapping>(`${this.apiUrl}/mappings`, mapping);
  }

  deleteMapping(id: number) {
    return this.http.delete(`${this.apiUrl}/mappings/${id}`);
  }

  getEmployees() {
    return this.http.get<EmployeeDto[]>(`${this.apiUrl}/employees`);
  }

  createEmployee(employee: EmployeeDto) {
    return this.http.post<EmployeeDto>(`${this.apiUrl}/employees`, employee);
  }

  updateEmployee(id: number, employee: EmployeeDto) {
    return this.http.put<EmployeeDto>(`${this.apiUrl}/employees/${id}`, employee);
  }

  deleteEmployee(id: number) {
    return this.http.delete(`${this.apiUrl}/employees/${id}`);
  }

  getProjects() {
    return this.http.get<ProjectDto[]>(`${this.apiUrl}/projects`);
  }

  createProject(project: ProjectDto) {
    return this.http.post<ProjectDto>(`${this.apiUrl}/projects`, project);
  }

  updateProject(id: number, project: ProjectDto) {
    return this.http.put<ProjectDto>(`${this.apiUrl}/projects/${id}`, project);
  }

  deleteProject(id: number) {
    return this.http.delete(`${this.apiUrl}/projects/${id}`);
  }
}

export interface EmployeeProjectMapping {
  id: number;
  employee: EmployeeDto;
  project: ProjectDto;
  assignedDate: string;
}