import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {UserService} from "../service/user.service"
import {Router} from "@angular/router"
import {User} from "../models/user.model"

@Component({
  selector   : 'app-login',
  templateUrl: './login.component.html',
  styleUrls  : ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public signinForm: FormGroup
  public error: boolean

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm() {
    this.signinForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  public Submit() {
    let formValue = this.signinForm.value
    let user      = {username: formValue['username'], password: formValue['password']}
    this.userService.login(user).subscribe((data: any) => {
      console.log("ok")
      console.log(data)
      this.userService.setUser(data)
      // this.router.navigate(['admin'])
    }, callback => {
      console.log("error")
      console.log(callback)
      this.error = true
    })
  }
}
