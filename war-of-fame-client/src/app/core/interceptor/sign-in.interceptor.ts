import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {Router} from '@angular/router';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignInInterceptor implements HttpInterceptor {
  readonly LOGIN = 'login';
  readonly SIGNUP = 'signup';
  readonly CREATE = 'create';
  readonly ALL = '/furniture/all';
  readonly DETAILS = 'details';
  readonly DELETE = 'delete';
  readonly EDIT = 'edit';
  readonly MY_FURNITURE_URL = '/furniture/mine';
  readonly ALL_URL = '/all';
  readonly SIGN_IN_URL = '/signin';
  readonly HOME_URL = '/home';
  readonly AUTH_TOKEN = 'authToken';
  readonly TOKEN = 'token';
  readonly USERNAME = 'username';
  readonly USER = 'user';
  readonly NAME = 'name';

  constructor(
    // private toastr: ToastrService,
    private router: Router
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req)
      .pipe(
        tap(
          (event: HttpEvent<any>) => {
            if (event instanceof HttpResponse && req.url.endsWith(this.LOGIN)) {
              this.setDataToLocalStorage(event.body);
              // this.toastr.success(event.body.message);
              this.router.navigate([this.HOME_URL]);
            } else {
              if (event instanceof HttpResponse && req.url.endsWith(this.SIGNUP)) {
                // this.toastr.success(event.body.message);
                this.router.navigate([this.SIGN_IN_URL]);
              } else {
                if (event instanceof HttpResponse && req.url.endsWith(this.CREATE)) {
                  // this.toastr.success(event.body.message);
                  this.router.navigate([this.ALL]);
                } else {
                  if (event instanceof HttpResponse && req.url.indexOf(this.DETAILS) !== -1) {
                    if (event.body.message) {
                      // this.toastr.error(event.body.message);
                      this.router.navigate([this.ALL_URL]);
                    }
                  } else {
                    if (event instanceof HttpResponse && req.url.indexOf(this.DELETE) !== -1) {
                      if (event.body.success) {
                        // this.toastr.success(event.body.message);
                      } else {
                        // this.toastr.error(event.body.message);
                        this.router.navigate([this.MY_FURNITURE_URL]);
                      }
                    } else {
                      if (event instanceof HttpResponse && req.url.includes(this.EDIT)) {
                        // this.toastr.success(event.body.message);
                        this.router.navigate([this.ALL]);
                      } else {
                        if (event instanceof HttpResponse && req.url.endsWith(this.DELETE)) {
                          // this.toastr.success(event.body.message);
                          this.router.navigate([this.ALL]);
                        }
                      }
                    }
                  }
                }
              }
            }
          })
      );
  }

  private setDataToLocalStorage(res: object): void {
    localStorage.setItem(this.AUTH_TOKEN, res[this.TOKEN]);
    localStorage.setItem(this.USERNAME, JSON.stringify(res[this.USER]));
  }
}
