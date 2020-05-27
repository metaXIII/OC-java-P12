import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"

@Component({
  selector   : 'app-article',
  templateUrl: './article.component.html',
  styleUrls  : ['./article.component.scss']
})
export class ArticleComponent implements OnInit {
  // collectionSize = this.Countries.length;
  pageSize = 20;
  page: number = 1
  country: number

  // get countries() {
  //   return this.Countries
  //     .map((country, i) => ({id: i + 1, ...country}))
  //     .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  // }

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
