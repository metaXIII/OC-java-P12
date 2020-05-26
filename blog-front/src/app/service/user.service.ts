import {Injectable} from '@angular/core';
import {Router} from "@angular/router"
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {User} from "../models/user.model"

@Injectable()
export class UserService {
  private user: User = null

  constructor(private router: Router, private httpClient: HttpClient) {
  }

  isConnected = () => {
    return this.getUser();
  }

  setUser(data: User) {
    this.user = data
  }

  getUser() {
    return this.user
  }

  private logout() {
    this.user = null
  }

  login = (form: any) => {
    this.logout()
    form          = {username: form['username'], password: form['password']}
    const options = new HttpHeaders(form ? {Authorization: 'Basic ' + window.btoa(form.username + ':' + form.password)} : {})
    return this.httpClient.get('/service/user/login', {headers: options})
  }
}
