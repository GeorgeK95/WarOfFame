export class SignInResponseModel {
  constructor(
    public accessToken: string,
    public tokenType: string,
    public username: string
  ) {
  }

}
