import {StatisticsComponent} from './statistics/statistics.component';
import {MessagesComponent} from './messages/messages.component';
import {MapComponent} from './map/map.component';
import {ReportsComponent} from './reports/reports.component';
import {GameComponent} from './game/game.component';
import {ClanComponent} from './clan/clan.component';

const GAME = 'game';
const EMPTY = '';
const KINGDOM = 'kingdom';
const MAP = 'map';
const STATISTICS = 'statistics';
const REPORTS = 'reports';
const MESSAGES = 'messages';
const FULL = 'full';
const CLAN = 'clan/:name';

export const gameRoutes = [
  // {path: EMPTY, component: GameComponent},
  {path: KINGDOM, component: GameComponent},
  {path: CLAN, component: ClanComponent},
  {path: MAP, component: MapComponent},
  {path: STATISTICS, component: StatisticsComponent},
  {path: REPORTS, component: ReportsComponent},
  {path: MESSAGES, component: MessagesComponent}
];
