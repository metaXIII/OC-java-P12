import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import * as ClassicEditor from "@ckeditor/ckeditor5-build-classic"

@Component({
  selector   : 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls  : ['./new-article.component.scss']
})
export class NewArticleComponent implements OnInit {
  public articleForm: FormGroup
  public error: boolean
  public Editor = ClassicEditor;


  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm() {
    this.articleForm = this.formBuilder.group({
      titre: ['', Validators.required],
      synopsis: ['', Validators.required],
      tags: ['', Validators.required],
      content: ['', Validators.required],
    })
  }

  public Submit() {
    let formValue = this.articleForm.value
    // let user      = {username: formValue['username'], password: formValue['password']}
  }

}
