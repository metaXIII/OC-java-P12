import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"

@Component({
  selector   : 'app-article',
  templateUrl: './article.component.html',
  styleUrls  : ['./article.component.scss']
})
export class ArticleComponent implements OnInit {
  Countries    = [
    {
      name      : 'Russia',
      flag      : 'f/f3/Flag_of_Russia.svg',
      area      : 17075200,
      population: 146989754
    },
    {
      name      : 'Canada',
      flag      : 'c/cf/Flag_of_Canada.svg',
      area      : 9976140,
      population: 36624199
    },
    {
      name      : 'United States',
      flag      : 'a/a4/Flag_of_the_United_States.svg',
      area      : 9629091,
      population: 324459463
    },
    {
      name      : 'China',
      flag      : 'f/fa/Flag_of_the_People%27s_Republic_of_China.svg',
      area      : 9596960,
      population: 1409517397
    }
  ];
  collectionSize = this.Countries.length;
  pageSize = 20;
  page: number = 1
  country: number

  get countries() {
    return this.Countries
      .map((country, i) => ({id: i + 1, ...country}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }

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
