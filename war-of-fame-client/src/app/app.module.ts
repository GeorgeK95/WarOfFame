import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './components/home/home.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppRouter} from './app.router';
import {FormsModule} from '@angular/forms';
import {AboutComponent} from './components/about/about.component';
import {ServiceModule} from './core/service/services.module';
import {GuardsModule} from './core/guard/guards.module';
import {SharedModule} from './components/shared/shared.module';
import {AuthModule} from './components/auth/auth.module';
import {GameModule} from './components/game/game.module';
import {ErrorInterceptor} from './core/interceptor/error.interceptor';
import {SignInInterceptor} from './core/interceptor/sign-in.interceptor';
import {TokenInterceptor} from './core/interceptor/token.interceptor';
import {AuthService} from './core/service/auth/auth.service';
import {ContactsComponent} from './components/contacts/contacts.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ContactsComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRouter,
    ServiceModule,
    AuthModule,
    FormsModule,
    SharedModule,
    GuardsModule,
    GameModule
  ],
  providers: [
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: SignInInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
