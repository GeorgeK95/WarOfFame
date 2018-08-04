import {NgModule} from '@angular/core';
import {gameComponents} from './index';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {gameRoutes} from './game.routing';

@NgModule({
  declarations: [
    ...gameComponents
  ],
  imports: [
    FormsModule,
    RouterModule.forChild(gameRoutes)
  ]/*,
  providers:[

  ]*/
})

export class GameModule {
}
