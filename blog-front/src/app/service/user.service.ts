import {Injectable} from '@angular/core';
import {Router} from "@angular/router"
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {User} from "../models/user.model"
import {FormBuilder} from "@angular/forms"

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
    sessionStorage.setItem("user", JSON.stringify(this.user));
  }

  getUser() {
    let memory = sessionStorage.getItem("user")
    if (memory)
      this.user = JSON.parse(memory)
    return this.user
  }

  logout() {
    sessionStorage.setItem("user", null);
    this.user = null
  }

  login = (form: any) => {
    this.logout()
    form          = {username: form['username'], password: form['password']}
    const options = new HttpHeaders(form ? {Authorization: 'Basic ' + window.btoa(form.username + ':' + form.password)} : {})
    return this.httpClient.get('/service/user/login', {headers: options})
  }

  updatePassword = (formValue: FormBuilder) => {
    let form = {
      password   : formValue['password'],
      newPassword: formValue['newPassword'],
      username   : this.getUser().username
    }
    return this.httpClient.put("/service/user/updatePassword", form);
  }

}
