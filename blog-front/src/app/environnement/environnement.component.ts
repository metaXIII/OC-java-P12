import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"

@Component({
  selector   : 'app-environnement',
  templateUrl: './environnement.component.html',
  styleUrls  : ['./environnement.component.scss']
})
export class EnvironnementComponent implements OnInit {

  data = {
    environnement: '',
    about: ''
  }

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getEnvironnement().subscribe((resp: any) => {
      this.data.environnement = resp[0]
      this.data.about = resp[1]
    }, err => {
      console.log(err)
    })
  }

}
