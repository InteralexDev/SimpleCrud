import {Component, OnInit} from '@angular/core';
import { EmployeeService } from "../../core/service/employee.service";
import {Employee} from "../../core/model/employee.model";
import {Router} from "@angular/router";
import {CreateEmployeeModalComponent} from "../../components/modal/create-employee-modal/create-employee-modal.component";
import {MatDialog} from '@angular/material/dialog';
import {DeleteEmployeeModalComponent} from "../../components/modal/delete-employee-modal/delete-employee-modal.component";
import {EditEmployeeModalComponent} from "../../components/modal/edit-employee-modal/edit-employee-modal.component";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  employees: Employee[] = [];
  displayedColumns = ['id', 'name', 'phoneNbr', 'actions'];
  effectColumns = ['id', 'name', 'phoneNbr'];

  constructor(private matDialogModule:MatDialog,
              private employeeService: EmployeeService,
              private router: Router) {}

  ngOnInit() {
    this.employeeService.employees$.subscribe(employees => {
      this.employees = employees;
    });
    this.employeeService.getEmployees();
  }

  navigateToEmployeePage(id: number) {
    this.router.navigate(['/employees/' + id]);
  }

  isRowVisible(row: any) {
    return !row.isDeleted;
  }

  createEmployee() {
    let dialogRef = this.matDialogModule.open(CreateEmployeeModalComponent, {
      height: '385px',
      width: '600px',
      autoFocus: false,
      data: {
        dataKey: this.employees
      }
    });
  }

  deleteEmployee(id: number) {
    let dialogRef = this.matDialogModule.open(DeleteEmployeeModalComponent, {
      height: '150px',
      width: '200px',
      autoFocus: false,
      data: {
          id: id,
      }
    });
  }

  editEmployee(employee : Employee) {
    if (employee.skills == null) {
      employee.skills = [];
    }
    let dialogRef = this.matDialogModule.open(EditEmployeeModalComponent, {
      height: '385px',
      width: '600px',
      autoFocus: false,
      data: {
        id: employee.id,
        name: employee.name,
        phoneNbr: employee.phoneNbr,
        skills: employee.skills,
        notes: employee.notes
      }
    });
  }
}
