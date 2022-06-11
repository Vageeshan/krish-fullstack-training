import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'em-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {

  color: string = '';
  bgClass: string = '';
  @Input() progress: number = 0;
  @Input() firstName: string = '';
  @Output() progressClickEvent: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
  }

  ngOnInit(): void {
    if (this.progress < 0 || this.progress > 100) {
      this.progress = 0;
    }
    if (this.progress < 35) {
      this.bgClass = 'bg-danger';
    } else if (this.progress < 75) {
      this.bgClass = 'bg-warning';
    } else {
      this.bgClass = 'bg-success';
    }
  }

  handleOnClick = () => {
    this.progressClickEvent.emit(`${this.firstName}'s Progress is ${this.progress} %`);
  }
}
