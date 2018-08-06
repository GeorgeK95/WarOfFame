import {Component, OnInit} from '@angular/core';
import {UserModel} from '../../../core/model/user.model';
import {StatisticsService} from '../../../core/service/statistics/statistics.service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  readonly CARET_DOWN = 'caret-down';
  readonly CARET_UP = 'caret-up';
  readonly ALL_USERS = 'allUsers';
  private users: UserModel[];
  private sortedByIdUsers: UserModel[];
  private sortedByPopulationUsers: UserModel[];
  private sortedByTownsUsers: UserModel[];
  private page = 1;
  private itemsPerPage = 6;
  private popCaretClass = this.CARET_UP;
  private townsCaretClass = this.CARET_UP;
  private idsCaretClass = this.CARET_UP;

  constructor(private service: StatisticsService) {
  }

  ngOnInit() {
    this.service.getStatistics()
      .subscribe((res) => {
        this.users = res.allUsers;
        this.sortedByIdUsers = res.allUsers;
        this.sortedByPopulationUsers = res.sortedByPopulation;
        this.sortedByTownsUsers = res.sortedByTownsCount;
      });
  }

  orderByPopulation() {
    this.users = this.sortedByPopulationUsers.reverse();
    this.popCaretClass = this.popCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderByTowns() {
    this.users = this.sortedByTownsUsers.reverse();
    this.townsCaretClass = this.townsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderById() {
    this.users = this.sortedByIdUsers.reverse();
    this.idsCaretClass = this.idsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  searchByUsername(targetUsername: string) {
    const found = this.sortedByIdUsers.filter((user: UserModel) => user.username.includes(targetUsername));

    if (found) {
      this.users = found;
    }
  }

  seremise(id: number) {
    console.log(id);
  }
}
