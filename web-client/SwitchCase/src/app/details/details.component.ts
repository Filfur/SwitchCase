import { Component, OnInit } from '@angular/core';
import {SKINS} from "../skin"

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  skins = SKINS;
  constructor() { }

  ngOnInit() {
  }

}
