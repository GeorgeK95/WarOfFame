import {Component, OnInit} from '@angular/core';
import {UserModel} from '../../../core/model/user.model';
import {UserService} from '../../../core/service/user/user.service';

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
  private itemsPerPage = 5;
  private popCaretClass = this.CARET_DOWN;
  private townsCaretClass = this.CARET_DOWN;
  private idsCaretClass = this.CARET_DOWN;

  constructor(private service: UserService) {
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
    // this.sortedByPopulationUsers = this.sortedByPopulationUsers.reverse();
    this.popCaretClass = this.popCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderByTowns() {
    this.users = this.sortedByTownsUsers.reverse();
    // this.sortedByTownsUsers = this.sortedByTownsUsers.reverse();
    this.townsCaretClass = this.townsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }

  orderById() {
    this.users = this.sortedByIdUsers.reverse();
    // this.sortedByIdUsers = this.sortedByIdUsers.reverse();
    this.idsCaretClass = this.idsCaretClass === this.CARET_DOWN ? this.CARET_UP : this.CARET_DOWN;
  }
}
