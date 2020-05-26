export class User {
  constructor(
    public email: string,
    public username: string,
    public usernamePublic: string,
    public twitter: string,
    public linkedin: string,
    public github: string,
    public environnement: string,
    public accountNonExpired: boolean,
    public accountNonLocked: boolean,
    public credentialsNonExpired: boolean,
    public enabled: boolean,
    public about: string
  ) {
  }
}
