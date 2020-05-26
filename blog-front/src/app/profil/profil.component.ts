import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import * as ClassicEditor from "@ckeditor/ckeditor5-build-classic"

@Component({
  selector   : 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls  : ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  public profilForm: FormGroup
  public error: boolean
  public Editor = ClassicEditor;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm() {
    this.profilForm = this.formBuilder.group({
      oldPassword   : [''],
      password: [''],
      newPassword    : [''],
      username    : [''],
      usernamePublic    : [''],
      github    : [''],
      linkedin    : [''],
      twitter    : [''],
      about    : [''],
      environnement : [''],
    })
  }

  Submit() {
    let formValue = this.profilForm.value
    // let user      = {username: formValue['username'], password: formValue['password']}
  }
}
