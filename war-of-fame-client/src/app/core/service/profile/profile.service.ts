import {Injectable} from '@angular/core';
import {UserModel} from '../../model/user/user.model';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  readonly profileUrl = 'http://localhost:8080/game/user/';

  constructor(private httpClient: HttpClient, private activatedRoute: ActivatedRoute) {
  }

  loadProfile() {
    console.log(this.activatedRoute.snapshot.url);
    // return this.httpClient.get<UserModel[]>(this.profileUrl);
  }
}
