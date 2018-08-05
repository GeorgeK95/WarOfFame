import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../../core/service/auth/auth.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  readonly HOME_URL = '/';
  readonly DELETED = 'deleted';
  readonly SIGN_OUT = 'signout';
  readonly SIGNED_OUT_SUCCESSFULLY_MESSAGE = 'Signed out successfully.';
  readonly SUCCESS = 'Success.';

  constructor(private service: AuthService, private router: Router, private toastr: ToastrService) {
  }

  onLogout() {
    this.service.authToken = this.DELETED;
    localStorage.clear();
    this.toastr.info(this.SIGNED_OUT_SUCCESSFULLY_MESSAGE, this.SUCCESS);
    this.router.navigate([this.HOME_URL]);
  }

  ngOnInit() {
  }

  isLoggedIn() {
    return this.service.checkIfLoggedIn();
  }

}
