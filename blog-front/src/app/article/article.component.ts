import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"
import {UserService} from "../service/user.service"
import {ArticleService} from "../service/article.service"
import {Article} from "../models/article.model"

@Component({
  selector   : 'app-article',
  templateUrl: './article.component.html',
  styleUrls  : ['./article.component.scss']
})
export class ArticleComponent implements OnInit {
  articles: any

  constructor(private userService: UserService, public articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.articleService.findAllAdmin().subscribe((resp: [Article]) => {
      this.articles = resp
    }, err => {
      console.log(err)
    })
  }

  modify(id: number) {
    this.router.navigate(['admin/modify/' + id])
  }

  delete(country: number) {
    //todo delete by id
    alert('should delete by id')
  }
}
