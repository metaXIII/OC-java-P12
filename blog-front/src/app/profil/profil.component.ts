import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import * as ClassicEditor from "@ckeditor/ckeditor5-build-classic"
import {User} from "../models/user.model"

@Component({
  selector   : 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls  : ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  public profilForm: FormGroup
  public passwordForm: FormGroup
  public userForm: FormGroup
  public error: boolean
  public Editor = ClassicEditor;
  user: User

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.user = this.userService.getUser()
    console.log(this.user)
    this.initForms();
  }

  private initForms() {
    this.profilForm   = this.formBuilder.group({
      about        : [this.user.about],
      environnement: [this.user.environnement],
    })
    this.userForm     = this.formBuilder.group({
      username      : [this.user.username],
      usernamePublic: [this.user.usernamePublic],
      github        : [this.user.github],
      linkedin      : [this.user.linkedin],
      twitter       : [this.user.twitter],
    })
    this.passwordForm = this.formBuilder.group({
      password   : ['', Validators.required],
      newPassword: ['', Validators.required]
    })
  }

  SubmitPassword() {
    let formValue = this.passwordForm.value
    if (formValue.password === formValue.newPassword) {
      this.userService.updatePassword(formValue).subscribe((resp) => {
        console.log('Tout s\'est bien passé')
      }, err => {
        console.log(err)
      })
    }
  }

  SubmitProfil() {
    let formValue = this.profilForm.value
    // let user      = {username: formValue['username'], password: formValue['password']}
  }

  SubmitUser() {
    let formValue = this.userForm.value
    // let user      = {username: formValue['username'], password: formValue['password']}
  }
}
