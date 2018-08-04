import {OnInit} from '@angular/core';

export class SignUpModel implements OnInit {

  constructor(
    public username: string,
    public password: string,
    public confirm: string,
    public email: string,
  ) {
  }

  ngOnInit() {
  }

}
