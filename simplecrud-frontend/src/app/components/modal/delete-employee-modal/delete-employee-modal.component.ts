import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {EmployeeService} from "../../../core/service/employee.service";
import {Router} from "@angular/router";
import {Employee} from "../../../core/model/employee.model";

@Component({
  selector: 'app-delete-employee-modal',
  templateUrl: './delete-employee-modal.component.html',
  styleUrls: ['./delete-employee-modal.component.scss']
})
export class DeleteEmployeeModalComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Employee, public matDialogModule:MatDialog, private http: HttpClient, private employeeService:EmployeeService, private router:Router) {}

  deleteEmployee() {
    this.employeeService.deleteEmployee((this.data.id));
    this.matDialogModule.closeAll();
    this.router.navigate(['/employees']);
  }
}
