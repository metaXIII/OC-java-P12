import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import * as ClassicEditor from "@ckeditor/ckeditor5-build-classic"
import {ArticleService} from "../service/article.service"
import {Router} from "@angular/router"

@Component({
    selector   : 'app-new-article',
    templateUrl: './new-article.component.html',
    styleUrls  : ['./new-article.component.scss']
})
export class NewArticleComponent implements OnInit {
    public articleForm: FormGroup
    public error: boolean
    public Editor = ClassicEditor;


    constructor(private formBuilder: FormBuilder, private articleService: ArticleService, private router: Router) {
    }

    ngOnInit(): void {
        this.initForm();
    }

    private initForm() {
        this.articleForm = this.formBuilder.group({
            titre   : ['', Validators.required],
            synopsis: ['', Validators.required],
            tags    : ['', Validators.required],
            content : ['', Validators.required],
        })
    }

    public Submit() {
        let formValue = this.articleForm.value
        this.articleService.insert(formValue).subscribe(resp => {
            this.router.navigate(['admin/articles'])
        }, err => {
            this.error = true
        })
    }

}
