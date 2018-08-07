import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from '../../service/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class GameGuard implements CanActivate {
  readonly LOGIN_URL = '/user/signin';

  constructor(private service: AuthService, private router: Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.service.checkIfLoggedIn()) {
      return true;
    } else {
      this.router.navigate([this.LOGIN_URL]);
      return false;
    }
  }
}
