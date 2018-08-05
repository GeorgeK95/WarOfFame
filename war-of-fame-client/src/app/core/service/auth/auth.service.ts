import {Injectable} from '@angular/core';
import {SignUpModel} from '../../model/sign-up.model';
import {SignInModel} from '../../model/sign-in.model';
import {HttpClientService} from '../http-client.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  readonly AUTH_TOKEN = 'authtoken';
  readonly registerUrl = `http://localhost:8080/auth/signup`;
  readonly loginUrl = 'http://localhost:8080/auth/signin';

  private _authToken: string;

  constructor(private httpClient: HttpClientService) {
  }

  register(registerModel: SignUpModel) {
    return this.httpClient.post<SignUpModel>(this.registerUrl, registerModel);
  }

  login(loginModel: SignInModel) {
    return this.httpClient.post(this.loginUrl, loginModel);
  }

  checkIfLoggedIn() {
    return this.authToken === localStorage.getItem(this.AUTH_TOKEN);
  }

  get authToken(): string {
    return this._authToken;
  }

  set authToken(value: string) {
    this._authToken = value;
  }
}
