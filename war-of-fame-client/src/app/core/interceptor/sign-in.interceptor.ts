import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {Router} from '@angular/router';
import {Injectable} from '@angular/core';
import {ToastrService} from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class SignInInterceptor implements HttpInterceptor {
  readonly SIGN_IN = 'signin';
  readonly SIGN_UP = 'signup';
  readonly USERNAME = 'username';
  readonly ACCESS_TOKEN = 'accessToken';
  readonly SIGN_IN_URL = '/signin';
  readonly ABOUT_URL = '/about';
  readonly HOME_URL = '/home';
  readonly AUTH_TOKEN = 'authtoken';
  readonly SUCCESS = 'Success.';
  readonly SIGNED_IN_SUCCESSFULLY_MESSAGE = 'Signed in successfully.';

  constructor(
    private toastr: ToastrService,
    private router: Router
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req)
      .pipe(
        tap(
          (event: HttpEvent<any>) => {
            if (event instanceof HttpResponse && req.url.endsWith(this.SIGN_IN)) {
              this.setDataToLocalStorage(event.body);
              this.toastr.success(this.SIGNED_IN_SUCCESSFULLY_MESSAGE, this.SUCCESS);
              this.router.navigate([this.HOME_URL]);
            } else {
              if (event instanceof HttpResponse && req.url.endsWith(this.SIGN_UP)) {
                this.toastr.success(event.body, this.SUCCESS);
                this.router.navigate([this.SIGN_IN_URL]);
              }
            }
          }
        )
      );
  }

  private setDataToLocalStorage(res: object): void {
    localStorage.setItem(this.AUTH_TOKEN, res[this.ACCESS_TOKEN]);
    localStorage.setItem(this.USERNAME, res[this.USERNAME]);
  }
}
