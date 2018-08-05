import {StatisticsComponent} from './statistics/statistics.component';
import {MessagesComponent} from './messages/messages.component';
import {MapComponent} from './map/map.component';
import {ReportsComponent} from './reports/reports.component';
import {GameComponent} from './game/game.component';
import {GameGuard} from '../../core/guard/game/game.guard';

const GAME = 'game';
const EMPTY = '';
const KINGDOM = 'kingdom';
const MAP = 'map';
const STATISTICS = 'statistics';
const REPORTS = 'reports';
const MESSAGES = 'messages';
const FULL = 'full';

export const gameRoutes = [
  // {path: '', component: BooksListComponent},
  // {path: 'details/:id', component: BookDetailsComponent},

  {path: EMPTY, component: GameComponent},
  // {path: KINGDOM, component: GameComponent},
  {path: MAP, component: MapComponent},
  {path: STATISTICS, component: StatisticsComponent},
  {path: REPORTS, component: ReportsComponent},
  {path: MESSAGES, component: MessagesComponent}
];
