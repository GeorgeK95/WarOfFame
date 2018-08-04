import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptor implements HttpInterceptor {
  readonly AUTHTOKEN = 'authToken';

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.retrieveToken() !== null) {
      req = req.clone({
        setHeaders: {
          'Authorization': 'Bearer ' + this.retrieveToken(),
          'Content-Type': 'application/json'
        }
      });
    }

    return next.handle(req);
  }

  private retrieveToken(): string {
    return localStorage.getItem(this.AUTHTOKEN);
  }
}
