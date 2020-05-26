import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"
import {Router} from "@angular/router"

@Component({
  selector   : 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls  : ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  ok: any

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.ok = JSON.stringify(this.userService.getUser())
  }

  navigate(article: string) {
    this.router.navigate([article])
  }
}
