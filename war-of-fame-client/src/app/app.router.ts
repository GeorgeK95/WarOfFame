import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {ContactsComponent} from './components/contacts/contacts.component';
import {AboutComponent} from './components/about/about.component';
import {GameModule} from './components/game/game.module';
import {PageNotFoundComponent} from './components/shared/page-not-found/page-not-found.component';
import {AuthModule} from './components/auth/auth.module';

const FULL = 'full';
const ABOUT = 'about';
const AUTH = 'auth';
const GAME = 'game';
const CONTACTS = 'contacts';
const ALL = '**';
const HOME = '';

const appRoutes = [
  {path: HOME, component: HomeComponent, pathMatch: FULL},
  {path: AUTH, loadChildren: () => AuthModule},
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
