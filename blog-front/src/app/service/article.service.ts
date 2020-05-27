import {Injectable} from '@angular/core';
import {Router} from "@angular/router"
import {HttpClient} from "@angular/common/http"
import {User} from "../models/user.model"
import {UserService} from "./user.service"

@Injectable()
export class ArticleService {
  private user: User = null
  options        = {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'};

  constructor(private router: Router, private httpClient: HttpClient, private userService: UserService) {
  }

  findAll = (page: number, pageSize: number) => {
    return this.httpClient.get("service/article/all/" + page + "/" + pageSize)
  }

  findAllCount = () => {
    return this.httpClient.get("service/article/count")
  }

  findById = (id: number) => {
    return this.httpClient.get("service/article/findById/" + id)
  }

  insert = (formValue: any) => {
    let form = {
      titre   : formValue['titre'],
      synopsis: formValue['synopsis'],
      tags    : formValue['tags'],
      content : formValue['content'],
      control : this.userService.getUser().username
    }
    return this.httpClient.post("service/article/insert", form);
  }

  getDate(localDate: Date) {
    return new Date(localDate).toLocaleDateString(undefined, this.options)
  }
}
