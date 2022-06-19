import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from "./student/components/student-list/student-list.component";
import {CreateStudentComponent} from "./student/components/create-student/create-student.component";
import {UpdateStudentComponent} from "./student/components/update-student/update-student.component";

const routes: Routes = [
  {path: 'students', component: StudentListComponent},
  {path: 'create-student', component: CreateStudentComponent},
  {path: 'edit-student/:id', component: UpdateStudentComponent},
  {path: '', redirectTo: 'students', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
