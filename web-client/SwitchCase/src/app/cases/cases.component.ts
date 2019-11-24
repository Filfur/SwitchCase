import { Component, OnInit } from '@angular/core';
import { Case, HEROES } from "../case";

@Component({
  selector: 'app-cases',
  templateUrl: './cases.component.html',
  styleUrls: ['./cases.component.scss']
})
export class CasesComponent implements OnInit {

  cases = HEROES;

  constructor() { }

  ngOnInit() {
  }

}
