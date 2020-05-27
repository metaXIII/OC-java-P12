import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"

@Component({
  selector   : 'app-index',
  templateUrl: './index.component.html',
  styleUrls  : ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  Countries      = [
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
  pageSize       = 20;
  page: number   = 1
  socials: any

  get countries() {
    return this.Countries
      .map((country, i) => ({id: i + 1, ...country}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getSocial().subscribe(resp => {
      this.socials = resp;
      console.log(this.socials)
    }, err => {
      console.log(err)
    })
  }

}
