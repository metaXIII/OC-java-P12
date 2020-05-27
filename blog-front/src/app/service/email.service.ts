import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private httpClient: HttpClient) {
  }

  add = (formValue: any) => {
    let form = {
      email: formValue['email']
    }
    return this.httpClient.post("service/mail/insert", form)
  }
}
