import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {ArticleService} from "../service/article.service"
import * as ClassicEditor from "@ckeditor/ckeditor5-build-classic"
import {ActivatedRoute, Router} from "@angular/router"
import {Article} from "../models/article.model"
import {Tag} from "../models/tag.model"

@Component({
  selector   : 'app-old-article',
  templateUrl: './old-article.component.html',
  styleUrls  : ['./old-article.component.scss']
})
export class OldArticleComponent implements OnInit {
  public articleForm: FormGroup
  public error: boolean
  public Editor         = ClassicEditor;
  private tag: Tag      = {
    id : 0,
    tag: ''
  }
  private data: Article = {
    titre    : '',
    tags     : this.tag,
    synopsis : '',
    content  : '',
    localDate: null
  }


  constructor(private formBuilder: FormBuilder, private articleService: ArticleService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.initForm();
    this.articleService.findById(this.route.snapshot.params['id']).subscribe((resp: Article) => {
      this.data = resp
      this.initForm();
    })
  }

  private initForm() {
    this.articleForm = this.formBuilder.group({
      titre   : [this.data.titre, Validators.required],
      synopsis: [this.data.synopsis, Validators.required],
      tags    : [this.data.tags.tag, Validators.required],
      content : [this.data.content, Validators.required],
    })
  }

  public Submit() {
    let formValue = this.articleForm.value
    this.articleService.update(formValue, this.route.snapshot.params['id']).subscribe(resp => {
      this.router.navigate(['admin/articles'])
    }, err => {
      this.error = true
    })
  }

  ngAfterViewInit(): void {
  }

}
