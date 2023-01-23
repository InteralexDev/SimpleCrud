import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Employee } from "../model/employee.model";
import {BehaviorSubject, Observable, Subscription, switchMap, tap} from "rxjs";
import {SnackbarService} from "./snackbar.service";

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {

  private employeesSubject = new BehaviorSubject<Employee[]>([]);
  employees$ = this.employeesSubject.asObservable();

  constructor(private http: HttpClient,
              private snackBar: SnackbarService) {}

  getEmployees() {
    this.http.get<Employee[]>(`http://localhost:8187/employees`).pipe(
      ).subscribe(employees => this.employeesSubject.next(employees));
  }

  getEmployee(id : number) : Observable<Employee> {
    return this.http.get<Employee>(`http://localhost:8187/employees/${id}`);
  }

  addEmployee(name: string | undefined, phoneNbr: string | undefined, skills: string[] | undefined, notes: string | undefined) {
    const employee = {
      id: 0,
      name: name,
      phoneNbr: phoneNbr,
      skills: skills,
      notes: notes
    };
    this.http.post('http://localhost:8187/employees/add', employee)
      .pipe(
        switchMap(() => this.http.get<Employee[]>('http://localhost:8187/employees'))
      ).subscribe(employees => this.employeesSubject.next(employees));
    this.snackBar.open("The employee " + name + " as been added !");
  }

  deleteEmployee(id: number) {
    const employee = {
      id: id
    }
    this.http.post('http://localhost:8187/employees/remove', employee)
      .pipe(
        switchMap(() => this.http.get<Employee[]>('http://localhost:8187/employees'))
      ).subscribe(employees => this.employeesSubject.next(employees));
    this.snackBar.open("The employee " + id + " as been removed !");
  }

  editEmployee(id: number, name: string, phoneNbr: string, skills: string[], notes: string) {
    const employee = {
      id: id,
      name: name,
      phoneNbr: phoneNbr,
      skills: skills,
      notes: notes
    };
    this.http.post('http://localhost:8187/employees/edit', employee)
      .pipe(
        switchMap(() => this.http.get<Employee[]>('http://localhost:8187/employees'))
      ).subscribe(employees => this.employeesSubject.next(employees));
    this.snackBar.open("The employee " + name + " as been edited !");
  }

}
