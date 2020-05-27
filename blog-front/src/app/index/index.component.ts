import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"
import {ArticleService} from "../service/article.service"
import {Article} from "../models/article.model"
import {Router} from "@angular/router"

@Component({
  selector   : 'app-index',
  templateUrl: './index.component.html',
  styleUrls  : ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  collectionSize = 0
  pageSize       = 20
  page: number   = 1
  done: boolean  = false
  socials: any
  Articles: [Article]
  categories: any

  constructor(private userService: UserService, private articleService: ArticleService, private router: Router) {
  }

  ngOnInit(): void {
    this.getArticles()
    if (!this.done) {
      this.articleService.findAllCount().subscribe((resp: number) => {
        this.collectionSize = resp
      }, err => {
        console.log(err)
      })
      this.done = true
    }
    this.userService.getSocial().subscribe(resp => {
      this.socials = resp;
    }, err => {
      console.log(err)
    })
    this.articleService.findAllTags().subscribe(resp => {
      this.categories = resp;
    }, err => {
      console.log(err)
    })
  }

  update(pageSize: number) {
    this.getArticles()
  }

  private getArticles() {
    this.articleService.findAll(this.page, this.pageSize).subscribe((resp: [Article]) => {
      this.Articles = resp
    }, err => {
      console.log(err)
    })
  }

  navigate(id: number) {
    this.router.navigate(['article/' + id])
  }

  get articles() {
    return this.Articles !== undefined ? this.Articles
      .map((article, i) => ({id: i + 1, ...article}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize) : []
  }

  search(category: string) {
    this.articleService.search(category).subscribe((resp: [Article]) => {
      this.Articles = resp
      this.collectionSize = this.Articles.length
    }, err => {
      console.log(err)
    })
  }
}
