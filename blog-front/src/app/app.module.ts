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
import {AuthGuard} from "./service/auth-guard.service"

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    FooterComponent,
    AdminComponent,
    EnvironnementComponent,
    LoginComponent
  ],
  imports     : [
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
    FormBuilder
  ],
  bootstrap   : [AppComponent]
})
export class AppModule {
}
