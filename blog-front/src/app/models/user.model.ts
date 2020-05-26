export class User {
  constructor(
    public email: string,
    public username: string,
    public accountNonExpired: boolean,
    public accountNonLocked: boolean,
    public credentialsNonExpired: boolean,
    public enabled: boolean,
  ) {
  }
}
