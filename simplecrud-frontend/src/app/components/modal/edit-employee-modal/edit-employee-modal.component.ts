import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {EmployeeService} from "../../../core/service/employee.service";
import {Router} from "@angular/router";
import {Employee} from "../../../core/model/employee.model";

@Component({
  selector: 'app-edit-employee-modal',
  templateUrl: './edit-employee-modal.component.html',
  styleUrls: ['./edit-employee-modal.component.scss']
})
export class EditEmployeeModalComponent {
  id: number = this.data.id;
  name: string = this.data.name;
  phoneNbr: string = this.data.phoneNbr;
  skill: string | undefined;
  skills: string[] = this.data.skills;
  notes: string = this.data.notes;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Employee, public matDialogModule:MatDialog, private http: HttpClient, private employeeService:EmployeeService, private router:Router) {}

  editEmployee() {
    console.log(this.id, this.name, this.phoneNbr, this.skills, this.notes);
    this.employeeService.editEmployee(this.id, this.name, this.phoneNbr, this.skills, this.notes)
    this.matDialogModule.closeAll();
    this.router.navigate(['/employees']);
  }

  addSkill() {
    if (this.skill != null) {
      this.skills.push(this.skill);
      console.log(this.skills);
    }
    console.log(this.skills);
  }

  areSkillsFull() {
    return this.skills.length >= 5;
  }

  removeSkillFromList(skill: string) {
    const index = this.skills.indexOf(skill);
    this.skills.splice(index, 1);
  }
}
