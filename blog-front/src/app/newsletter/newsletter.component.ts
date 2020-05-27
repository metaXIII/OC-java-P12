import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {EmailService} from "../service/email.service"

@Component({
  selector   : 'app-newsletter',
  templateUrl: './newsletter.component.html',
  styleUrls  : ['./newsletter.component.scss']
})
export class NewsletterComponent implements OnInit {
  subscriptionForm: FormGroup
  success: boolean
  error: boolean

  constructor(private formBuilder: FormBuilder, private emailService: EmailService) {
  }

  ngOnInit() {
    this.initForm()
  }

  Submit() {
    let formValue = this.subscriptionForm.value
    this.emailService.add(formValue).subscribe(resp => {
      this.success = true
    }, err => {
      this.error = true
    })
  }

  private initForm() {
    this.subscriptionForm = this.formBuilder.group({
      email: ['', Validators.required]
    })
  }
}
