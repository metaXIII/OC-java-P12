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
  }

  getUser() {
    return this.user
  }

  logout() {
    this.user = null
    this.httpClient.get("/service/user/logout").subscribe(resp => {
    });
    this.router.navigate(['index'])
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
    return this.httpClient.put("/service/user/updatePassword", form)
  }

  updateUser = (formValue: FormBuilder) => {
    let form = {
      username      : formValue['username'],
      usernamePublic: formValue['usernamePublic'],
      github        : formValue['github'],
      linkedin      : formValue['linkedin'],
      twitter       : formValue['twitter'],
      email         : formValue['email'],
      control       : this.getUser().username
    }
    return this.httpClient.put("service/user/updateUser", form)
  }

  updateProfil = (formValue: any) => {
    let form = {
      about        : formValue['about'],
      environnement: formValue['environnement'],
      control      : this.getUser().username
    }
    return this.httpClient.put("service/user/updateProfil", form)
  }

  getEnvironnement = () => {
    return this.httpClient.get("service/user/environnement")
  }

  getSocial = () => {
    return this.httpClient.get("service/user/social")
  }
}
