import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../../core/service/auth/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  readonly HOME_URL = '/';
  readonly AUTH_TOKEN = 'authtoken';
  readonly DELETED = 'deleted';

  constructor(private service: AuthService, private router: Router) {
  }

  onLogout() {
    this.service.authToken = this.DELETED;
    localStorage.removeItem(this.AUTH_TOKEN);
    this.router.navigate([this.HOME_URL]);
  }

  ngOnInit() {
  }

  isLoggedIn() {
    return this.service.checkIfLoggedIn();
  }

}
