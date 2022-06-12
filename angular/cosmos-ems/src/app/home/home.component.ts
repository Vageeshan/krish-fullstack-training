import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) {

  }

  ngOnInit(): void {
  }

  NavigateToEmployees = () => {
    this.router.navigate(['/employees']).then(r => console.log(r));
  }
}
