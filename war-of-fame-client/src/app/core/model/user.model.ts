export class UserModel {
  constructor(
    public username: string,
    public password: string,
    public confirm: string,
    public email: string,
  ) {
  }
}
