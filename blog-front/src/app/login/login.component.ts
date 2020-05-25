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
    if (formValue['password'] !== formValue['checkPassword']) {
      this.error = true
      return;
    }
    this.userService.login(formValue).subscribe((data: User) => {
      this.userService.setUser(data)
      this.router.navigate(['admin'])
    }, callback => {
      console.log(callback)
    })
  }
}
