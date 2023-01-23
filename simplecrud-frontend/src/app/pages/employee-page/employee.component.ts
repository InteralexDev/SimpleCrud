import {Component, OnInit} from '@angular/core';
import {Employee} from "../../core/model/employee.model";
import {EmployeeService} from "../../core/service/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DeleteEmployeeModalComponent} from "../../components/modal/delete-employee-modal/delete-employee-modal.component";
import {MatDialog} from "@angular/material/dialog";
import {EditEmployeeModalComponent} from "../../components/modal/edit-employee-modal/edit-employee-modal.component";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  currentEmployee: Employee | undefined;
  skills: string | undefined;
  id: number | undefined;
  loading: boolean = true;
  valid: boolean = false;

  constructor(private matDialogModule:MatDialog,
              private employeeService: EmployeeService,
              private route: ActivatedRoute,
              public router: Router) { }

  ngOnInit() {
    this.id = parseInt(<string>this.route.snapshot.paramMap.get('id'), 10);
    if (!isNaN(this.id)) {
      this.employeeService.getEmployee(this.id).subscribe(employee => {
        this.currentEmployee = employee;
        this.skills = employee != null && employee.skills != null ? employee.skills.join(' ') : '';
        this.loading = false;
        this.valid = true;
      });
    } else {
      this.loading = false;
    }
  }

  deleteCurrentEmployee() {
    let dialogRef = this.matDialogModule.open(DeleteEmployeeModalComponent, {
      height: '150px',
      width: '200px',
      autoFocus: false,
      data: {
        id: this.currentEmployee?.id,
      }
    });
  }

  editCurrentEmployee(employee: Employee) {
    employee.skills = (employee.skills == null) ? [] : employee.skills;
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
