import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./index/index.component"
import {AdminComponent} from "./admin/admin.component"
import {UserService} from "./service/user.service"
import {EnvironnementComponent} from "./environnement/environnement.component"
import {LoginComponent} from './login/login.component';


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'mon-environnement', component: EnvironnementComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent, canActivate: [UserService]},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
