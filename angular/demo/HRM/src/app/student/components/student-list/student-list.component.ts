import {Component, OnInit} from '@angular/core';
import {Student} from "../../model/student";
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})

export class StudentListComponent implements OnInit {

  students: Student[];

  constructor(private studentService: StudentService, private router: Router) {
  }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentList().subscribe(data => {
      this.students = data.response;
    })
  }

  handleEditBtnClick(id: number) {
    this.router.navigate(['edit-student', id]);
  }

  handleDeleteBtnClick(id: number) {
    this.studentService.deleteStudentById(id).subscribe(data => {
      location.reload();
    });
  }
}
