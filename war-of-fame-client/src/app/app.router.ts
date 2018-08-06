import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {ContactsComponent} from './components/contacts/contacts.component';
import {AboutComponent} from './components/about/about.component';
import {GameModule} from './components/game/game.module';
import {PageNotFoundComponent} from './components/shared/page-not-found/page-not-found.component';
import {SignInComponent} from './components/auth/signIn/sign-in.component';
import {SignUpComponent} from './components/auth/signUp/sign-up.component';

const FULL = 'full';
const USER_SIGNUP = 'user/signup';
const USER_SIGNIN = 'user/signin';
const USER_PROFILE = 'user/profile/:username';
const ABOUT = 'about';
const GAME = 'game';
const CONTACTS = 'contacts';
const CLAN = 'clan';
const ALL = '**';
const HOME = '';

const appRoutes = [
  {path: HOME, component: HomeComponent, pathMatch: FULL},
  {path: USER_SIGNUP, component: SignUpComponent},
  {path: USER_SIGNIN, component: SignInComponent},
  {path: USER_PROFILE, component: PageNotFoundComponent},
  {path: ABOUT, component: AboutComponent},
  {path: CONTACTS, component: ContactsComponent},
  {path: CLAN, component: PageNotFoundComponent},
  {path: GAME, /*canActivate: [GameGuard],*/ loadChildren: () => GameModule},
  {path: ALL, component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRouter {
}
