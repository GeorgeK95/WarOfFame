import {NgModule} from '@angular/core';
import {gameComponents} from './index';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {gameRoutes} from './game.routing';
import {CommonModule} from '@angular/common';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    ...gameComponents
  ],
  imports: [
    CommonModule,
    FormsModule,
    NgxPaginationModule,
    RouterModule.forChild(gameRoutes)
  ]/*,
  providers:[

  ]*/
})

export class GameModule {
}
