import {StatisticsComponent} from './statistics/statistics.component';
import {MessagesComponent} from './messages/messages.component';
import {MapComponent} from './map/map.component';
import {ReportsComponent} from './reports/reports.component';
import {GameComponent} from './game/game.component';
import {ClanComponent} from './clan/clan.component';
import {ProfileComponent} from './profile/profile.component';

const TOWN = 'town';
const MAP = 'map';
const STATISTICS = 'statistics';
const REPORTS = 'reports';
const USER = 'user/:name';
const MESSAGES = 'messages';
const CLAN = 'clan/:name';

export const gameRoutes = [
  {path: TOWN, component: GameComponent},
  {path: CLAN, component: ClanComponent},
  {path: MAP, component: MapComponent},
  {path: STATISTICS, component: StatisticsComponent},
  {path: USER, component: ProfileComponent},
  {path: REPORTS, component: ReportsComponent},
  {path: MESSAGES, component: MessagesComponent}
];
