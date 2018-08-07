import {UserResponseModel} from './user-response.model';

export class StatisticsResponseModel {
  constructor(
    public users: UserResponseModel[],
    public allUsers: UserResponseModel[], // sorted by id
    public sortedByTownsCount: UserResponseModel[],
    public sortedByPopulation: UserResponseModel[],
    // public sortedByIdUsers: UserResponseModel[]
  ) {
  }
}
