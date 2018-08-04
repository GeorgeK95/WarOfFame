import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GameGuard} from './game/game.guard';

@NgModule({
  providers: [GameGuard],
  imports: [
    CommonModule
  ]
})
export class GuardsModule {
}
