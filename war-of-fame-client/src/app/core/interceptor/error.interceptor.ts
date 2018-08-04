import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ErrorInterceptor implements HttpInterceptor {
  readonly UNAUTHORIZED_STATUS_CODE = 401;
  readonly BAD_REQUEST_STATUS_CODE = 400;
  readonly ERROR = 'Error!';
  readonly WARNING = 'Warning!';

  constructor(/*private toastr: ToastrService*/) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(
        catchError((err: HttpErrorResponse) => {
          if (err.status === this.UNAUTHORIZED_STATUS_CODE) {
            // this.toastr.error(err.error.message, this.ERROR);
          } else {
            if (err.status === this.BAD_REQUEST_STATUS_CODE) {
              // this.toastr.error(err.error.message, this.WARNING);
              for (const e in err.error.errors) {
                if (err.error.errors.hasOwnProperty(e)) {
                  // this.toastr.error(err.error.errors[e]);
                }
              }
            }
          }

          return throwError(err.error);
        })
      );
  }
}
