import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"

@Component({
  selector   : 'app-article',
  templateUrl: './article.component.html',
  styleUrls  : ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  modify(id: number) {
    alert('should modify by id')
    this.router.navigate(['admin/modify/' + id])
  }

  delete(country: number) {
    //todo delete by id
    alert('should delete by id')
  }
}
