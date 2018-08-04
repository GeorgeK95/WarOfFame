import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../core/service/auth/auth.service';
import {Router} from '@angular/router';
import {SignInModel} from '../../../core/model/sign-in.model';

@Component({
  selector: 'app-login',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  readonly AUTH_TOKEN = 'authtoken';
  readonly ACCESS_TOKEN = 'accessToken';
  readonly HOME_URL = '/';
  private login: SignInModel;

  constructor(private service: AuthService, private router: Router) {
  }

  onLogin() {
    this.service.login(this.login)
      .subscribe(res => {
        this.service.authToken = res[this.ACCESS_TOKEN];
        localStorage.setItem(this.AUTH_TOKEN, res[this.ACCESS_TOKEN]);
        this.router.navigate([this.HOME_URL]);
      }, error => console.log(error));
  }

  ngOnInit() {
    this.login = new SignInModel('', '');
  }

}
