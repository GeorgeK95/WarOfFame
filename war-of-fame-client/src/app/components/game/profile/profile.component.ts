import {Component, OnInit} from '@angular/core';
import {HttpClientService} from '../../../core/service/http-client.service';
import {AuthService} from '../../../core/service/auth/auth.service';
import {UserProfileResponseModel} from '../../../core/model/response/user-profile-response.model';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  private hasAuthorities: boolean;
  private user: UserProfileResponseModel;
  readonly NAME = 'name';

  constructor(
    private http: HttpClientService,
    private route: ActivatedRoute,
    private service: AuthService
  ) {
  }

  ngOnInit() {
    const profilePageUrlName = this.route.snapshot.paramMap.get(this.NAME);
    this.service.getCurrentlyLoggedInUser()
      .subscribe((res: UserProfileResponseModel) => {
        this.user = res;
        this.hasAuthorities = (profilePageUrlName === res.username) || (res.roles.length > 1);
      });
  }

}
