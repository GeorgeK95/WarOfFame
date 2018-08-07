import {Component, OnInit} from '@angular/core';
import {UserModel} from '../../../core/model/user.model';
import {StatisticsService} from '../../../core/service/statistics/statistics.service';
import {StatisticsResponseModel} from '../../../core/model/statistics-response.model';
import {UserResponseModel} from '../../../core/model/user-response.model';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  readonly CARET_DOWN = 'caret-down';
  readonly CARET_UP = 'caret-up';
  readonly ALL_USERS = 'allUsers';
  // private sortedByIdUsers: UserModel[];
  // private sortedByPopulationUsers: UserModel[];
  // private users: UserModel[];
  // private sortedByTownsUsers: UserModel[];
  private statistics: StatisticsResponseModel;
  private page = 1;
  private itemsPerPage = 6;
  private popCaretClass = this.CARET_UP;
  private townsCaretClass = this.CARET_UP;
  private idsCaretClass = this.CARET_UP;

  constructor(private service: StatisticsService) {
  }

  ngOnInit() {
    this.service.getStatistics()
      .subscribe((res: any) => {
        this.statistics = res/*.allUsers*/;
        this.statistics.users = res.allUsers;
        /* this.sortedByIdUsers = res.allUsers;
         this.sortedByPopulationUsers = res.sortedByPopulation;
         this.sortedByTownsUsers = res.sortedByTownsCount;*/
      });
  }

  orderByPopulation() {
    this.statistics.users = this.statistics.sortedByPopulation.reverse();
    this.popCaretClass = this.popCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderByTowns() {
    this.statistics.users = this.statistics.sortedByTownsCount.reverse();
    this.townsCaretClass = this.townsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderById() {
    this.statistics.users = this.statistics.allUsers.reverse();
    this.idsCaretClass = this.idsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  searchByUsername(targetUsername: string) {
    const found = this.statistics.allUsers.filter(
      (user: UserResponseModel) => user.username.includes(targetUsername)
    );

    if (found) {
      this.statistics.users = found;
    }
  }
}
