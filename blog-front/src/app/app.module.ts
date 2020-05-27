import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {IndexComponent} from './index/index.component';
import {FooterComponent} from './footer/footer.component';
import {AdminComponent} from './admin/admin.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from "@angular/material/tabs"
import {UserService} from "./service/user.service";
import {EnvironnementComponent} from './environnement/environnement.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'
import {FormBuilder, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from './login/login.component'
import {HttpClientModule} from "@angular/common/http"
import {AuthGuard} from "./service/auth-guard.service";
import {ArticleComponent} from './article/article.component';
import {NewArticleComponent} from './new-article/new-article.component';
import {ProfilComponent} from './profil/profil.component';
import {CKEditorModule} from "@ckeditor/ckeditor5-angular"
import {ArticleService} from "./service/article.service";
import {ViewComponent} from './view/view.component';
import {NewsletterComponent} from './newsletter/newsletter.component'
import {EmailService} from "./service/email.service"

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    FooterComponent,
    AdminComponent,
    EnvironnementComponent,
    LoginComponent,
    ArticleComponent,
    NewArticleComponent,
    ProfilComponent,
    ViewComponent,
    NewsletterComponent,
  ],
  imports     : [
    CKEditorModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTabsModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers   : [
    UserService,
    AuthGuard,
    FormBuilder,
    ArticleService,
    EmailService
  ],
  bootstrap   : [AppComponent]
})
export class AppModule {
}
