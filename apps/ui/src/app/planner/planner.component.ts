import {Component, computed, OnInit, signal, WritableSignal} from '@angular/core';

import {Store} from '@ngrx/store';
import {AppState} from '../shared/state/app.state';
import {loadEmployees, loadProjects} from '../shared/state/data/data.actions';
import {EmployeeDto, ProjectDto} from '../../generated';
import {selectEmployees, selectProjects} from '../shared/state/data/data.selectors';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { EmployeeProjectMapping, PlannerService } from './planner.service';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html'
})
export class PlannerComponent implements OnInit{
  mappings: EmployeeProjectMapping [] = []
  employees: EmployeeDto[] = [];
  projects: ProjectDto[] = [];

  currentDate = new Date();

  constructor(
    private store: Store<AppState>,
    private modalService: NgbModal,
    private plannerService: PlannerService
  ) {
    this.store.dispatch(loadEmployees());
    this.store.dispatch(loadProjects());

    this.store.select(selectEmployees).subscribe((employees) => {
      this.employees = employees;
    });
    this.store.select(selectProjects).subscribe((projects) => {
      this.projects = projects;
    });
  }

  ngOnInit() {
      this.loadMappings();
      this.loadEmployees();
      this.loadProjects();
  }

  loadMappings(){
    this.plannerService.getMappings().subscribe(data => this.mappings = data);
  }

  loadEmployees(){
    this.plannerService.getEmployees().subscribe(data => this.employees = data);
  }

  loadProjects(){
    this.plannerService.getProjects().subscribe(data => this.projects = data);
  }

  addMapping(employeeId: number, projectId: number, date: string){
    const mapping = {employee: {id: employeeId}, project: {id: projectId}, assignedDate: date};
    this.plannerService.createMapping(mapping).subscribe(() => this.loadMappings());
  }

  removeMapping(id: number){
    this.plannerService.deleteMapping(id).subscribe(()=> this.loadMappings);
  }
  //_____________separation of project from the GitHub____________________________
  previousWeek() {
    this.currentDate.setDate(this.currentDate.getDate() - 7);
  }

  nextWeek() {
    this.currentDate.setDate(this.currentDate.getDate() + 7);
  }

  nthDayOfWeek = (n: number) => {
    const cd = this.currentDate;
    const d = new Date(Date.UTC(cd.getFullYear(), cd.getMonth(), cd.getDate()));
    const dayNum = d.getUTCDay() || 7;
    d.setUTCDate(d.getUTCDate() + 1 - dayNum);
    d.setUTCDate(d.getUTCDate() + n);
    return d;
  };

  getWeekNumber(): number {
    const cd = this.currentDate;
    const d = new Date(Date.UTC(cd.getFullYear(), cd.getMonth(), cd.getDate()));
    const dayNum = d.getUTCDay() || 7;
    d.setUTCDate(d.getUTCDate() + 4 - dayNum);
    const yearStart = new Date(Date.UTC(d.getUTCFullYear(), 0, 1));
    return Math.ceil(((d.getTime() - yearStart.getTime()) / 86400000 + 1) / 7);
  }


}
