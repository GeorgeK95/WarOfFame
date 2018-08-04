import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {SignUpComponent} from './components/auth/signUp/sign-up.component';
import {SignInComponent} from './components/auth/signIn/sign-in.component';
import {ContactsComponent} from './components/contacts/contacts.component';
import {AboutComponent} from './components/about/about.component';
import {GameModule} from './components/game/game.module';

const FULL = 'full';
const AUTH_SIGNUP = 'auth/signup';
const AUTH_SIGNIN = 'auth/signin';
const ABOUT = 'about';
const GAME = 'game';
const CONTACTS = 'contacts';
const ALL = '**';
const HOME = '';

const appRoutes = [
  {path: HOME, component: HomeComponent, pathMatch: FULL},
  {path: AUTH_SIGNUP, component: SignUpComponent},
  {path: AUTH_SIGNIN, component: SignInComponent},
  {path: ABOUT, component: AboutComponent},
  {path: CONTACTS, component: ContactsComponent},
  {path: GAME, loadChildren: () => GameModule},
  {path: ALL, component: HomeComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRouter {
}
