import {Injectable} from '@angular/core';
import {HttpClientService} from '../http-client.service';
import {SignUpModel} from '../../model/sign-up.model';
import {UserModel} from '../../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  readonly statisticsUrl = 'http://localhost:8080/game/statistics';

  constructor(private httpClient: HttpClientService) {
  }

  getStatistics() {
    return this.httpClient.get<UserModel[]>(this.statisticsUrl);
  }
}
