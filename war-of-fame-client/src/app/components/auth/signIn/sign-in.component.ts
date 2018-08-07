import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../core/service/auth/auth.service';
import {Router} from '@angular/router';
import {SignInModel} from '../../../core/model/user/sign-in.model';
import {SignInResponseModel} from '../../../core/model/response/sign-in-response.model';

@Component({
  selector: 'app-login',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  readonly HOME_URL = '/';
  private login: SignInModel;

  constructor(private service: AuthService, private router: Router) {
  }

  onLogin() {
    this.service.login(this.login)
      .subscribe(() => {
        this.router.navigate([this.HOME_URL]);
      }, error => console.log(error));
  }

  ngOnInit() {
    this.login = new SignInModel('', '');
  }

}
