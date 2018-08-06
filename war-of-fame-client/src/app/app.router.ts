import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {SignUpComponent} from './components/auth/signUp/sign-up.component';
import {SignInComponent} from './components/auth/signIn/sign-in.component';
import {ContactsComponent} from './components/contacts/contacts.component';
import {AboutComponent} from './components/about/about.component';
import {GameModule} from './components/game/game.module';
import {PageNotFoundComponent} from './components/shared/page-not-found/page-not-found.component';
import {GameGuard} from './core/guard/game/game.guard';

const FULL = 'full';
const AUTH_SIGNUP = 'auth/signup';
const AUTH_SIGNIN = 'auth/signin';
const AUTH_PROFILE = 'auth/profile/:id';
const ABOUT = 'about';
const GAME = 'game';
const CONTACTS = 'contacts';
const ALL = '**';
const HOME = '';

const appRoutes = [
  {path: HOME, component: HomeComponent, pathMatch: FULL},
  {path: AUTH_SIGNUP, component: SignUpComponent},
  {path: AUTH_SIGNIN, component: SignInComponent},
  {path: AUTH_PROFILE, component: PageNotFoundComponent},
  {path: ABOUT, component: AboutComponent},
  {path: CONTACTS, component: ContactsComponent},
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
