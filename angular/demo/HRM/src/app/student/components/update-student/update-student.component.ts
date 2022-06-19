import {Component, OnInit} from '@angular/core';
import {Student} from "../../model/student";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  student: Student = new Student();
  id: number;

  constructor(private studentService: StudentService, private activatedRoute: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe(data => {
      this.student = data;
    })
  }

  handleSubmit() {
    this.studentService.updateStudent(this.id, this.student).subscribe(data => {
      this.router.navigate(['/']);
    });
  }
}
