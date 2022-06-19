import {Component, OnInit} from '@angular/core';
import {Student} from "../../model/student";
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  student: Student = new Student();

  constructor(private studentService: StudentService, private router:Router) {
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.studentService.saveStudent(this.student).subscribe(data => {
    this.navigate();
    });
  }

  private navigate(){
    this.router.navigate(['/students']);
  }
}
