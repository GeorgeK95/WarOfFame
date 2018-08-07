import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {SignUpModel} from '../../../core/model/sign-up.model';
import {AuthService} from '../../../core/service/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  readonly SIGN_IN_URL = '/user/signin';
  private register: SignUpModel;

  constructor(private service: AuthService, private router: Router) {
  }

  onRegister() {
    this.service.register(this.register)
      .subscribe(() => {
        this.router.navigate([this.SIGN_IN_URL]);
      });
  }

  ngOnInit() {
    this.register = new SignUpModel('', '', '', '');
  }

}
