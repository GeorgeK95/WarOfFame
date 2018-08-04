import {OnInit} from '@angular/core';

export class SignInModel implements OnInit {

  constructor(
    public username: string,
    public password: string
  ) {
  }

  ngOnInit() {
  }

}
