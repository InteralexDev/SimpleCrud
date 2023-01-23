import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home-page/home.component';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { EmployeeComponent } from './pages/employee-page/employee.component';
import {MatCardModule} from "@angular/material/card";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateEmployeeModalComponent } from './components/modal/create-employee-modal/create-employee-modal.component';
import {MatButtonModule} from "@angular/material/button";
import {NgbModalModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import { DeleteEmployeeModalComponent } from './components/modal/delete-employee-modal/delete-employee-modal.component';
import { EditEmployeeModalComponent } from './components/modal/edit-employee-modal/edit-employee-modal.component';
import {IConfig, NgxMaskDirective, NgxMaskPipe, provideEnvironmentNgxMask} from 'ngx-mask';
import { MatSnackBarModule } from '@angular/material/snack-bar';

const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EmployeeComponent,
    CreateEmployeeModalComponent,
    DeleteEmployeeModalComponent,
    EditEmployeeModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    NgbModule,
    NgbModalModule,
    MatDialogModule,
    MatIconModule,
    MatFormFieldModule,
    NgxMaskDirective,
    NgxMaskPipe,
    MatSnackBarModule
  ],
  providers: [
    {provide: MatDialogRef, useValue: {}},
    {provide: MAT_DIALOG_DATA, useValue: []},
    provideEnvironmentNgxMask(maskConfig),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
