import {NgModule} from '@angular/core';
import {authComponents} from './index';
import {FormsModule} from '@angular/forms';
import {AuthService} from '../../core/service/auth/auth.service';
import {RouterModule} from '@angular/router';
import {authRoutes} from './auth.routing';

@NgModule({
  declarations: [
    ...authComponents
  ],
  imports: [
    FormsModule,
    RouterModule.forChild(authRoutes)
  ],
  providers: [AuthService]
})

export class AuthModule {
}
