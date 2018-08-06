import {Injectable} from '@angular/core';
import {UserModel} from '../../model/user.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  readonly statisticsUrl = 'http://localhost:8080/game/statistics';

  constructor(private httpClient: HttpClient) {
  }

  getStatistics() {
    return this.httpClient.get<UserModel[]>(this.statisticsUrl);
  }
}
