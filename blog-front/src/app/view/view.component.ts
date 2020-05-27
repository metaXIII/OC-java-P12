import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router"
import {Article} from "../models/article.model"
import {ArticleService} from "../service/article.service"

@Component({
  selector   : 'app-view',
  templateUrl: './view.component.html',
  styleUrls  : ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  id: number
  article: Article = {
    titre    : '',
    content  : '',
    synopsis : '',
    tags     : null,
    localDate: new Date()
  }

  constructor(private route: ActivatedRoute, public articleService: ArticleService) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.params['id']
    this.articleService.findById(this.id).subscribe((resp: Article) => {
      this.article = resp
    }, err => {
      console.log(err)
    })
  }

}
