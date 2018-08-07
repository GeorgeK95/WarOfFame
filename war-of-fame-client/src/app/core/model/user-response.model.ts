export class UserResponseModel {
  constructor(
    public id: number,
    public username: string,
    public townsCount: number,
    public population: number
  ) {
  }
}
