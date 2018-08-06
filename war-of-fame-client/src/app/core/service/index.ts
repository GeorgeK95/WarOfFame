import {AuthService} from './auth/auth.service';
import {HttpClientService} from './http-client.service';
import {StatisticsService} from './statistics/statistics.service';

export const allServices = [
  AuthService, HttpClientService, StatisticsService
];
