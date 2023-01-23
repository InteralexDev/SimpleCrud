import {Component, Inject} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {EmployeeService} from "../../../core/service/employee.service";
import {Router} from "@angular/router";
import {SnackbarService} from "../../../core/service/snackbar.service";

@Component({
  selector: 'app-employee-modal',
  templateUrl: './create-employee-modal.component.html',
  styleUrls: ['./create-employee-modal.component.scss']
})
export class CreateEmployeeModalComponent {
  name: string | undefined;
  phoneNbr: string | undefined;
  skill: string | undefined;
  skills: string[] = [];
  notes: string | undefined;

  constructor(public matDialogModule:MatDialog,
              private http: HttpClient,
              private employeeService:EmployeeService,
              private router:Router) {}

  addEmployee() {
    this.employeeService.addEmployee(this.name, this.phoneNbr, this.skills, this.notes)
    this.matDialogModule.closeAll();
    this.router.navigate(['/employees']);
  }

  addSkill() {
    if (this.skill != null) {
      this.skills.push(this.skill);
      console.log(this.skills);
    }
  }

  areSkillsFull() {
    return this.skills.length >= 5;
  }

  removeSkillFromList(skill: string) {
    const index = this.skills.indexOf(skill);
    this.skills.splice(index, 1);
  }
}
