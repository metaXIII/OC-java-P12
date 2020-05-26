import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"

@Component({
  selector   : 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls  : ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  constructor(public userService: UserService) {
  }

  ngOnInit() {
  }

  logout() {
    this.userService.logout()
  }
}
