import { Component, OnInit } from '@angular/core';
import {SKINS} from "../skin"
import * as $ from 'jquery';
import { NONE_TYPE } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  skins = SKINS;
  case = {
    name: "SUCC Case",
    image: "../assets/images/case-1.png"
  }
  constructor() { }

  ngOnInit() {
    $(document).ready(function () {
      for (let i = 0; i < 3; i++) {
          $(".skins-list li").clone().appendTo(".skins-list");
      }
      $('.button').click(function () {
          $('.case-image').css({
              display: "none"
          })
          $('.carousel-wrapper').css({
            display: "block"
          })
          $('.skins-window').css({
              right: "0"
          })
          function selfRandom(min, max) {
              return Math.floor(Math.random() * (max - min + 1)) + min;
          }
          var x = selfRandom(50, 100);
         
          $('.skins-window').animate({
              right: ((x*130)+(x*8-12)-119)
          }, 10000, "swing", ()=>{alert("Better luck next time")});
      });
    });
  }

}
