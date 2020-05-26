import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./index/index.component"
import {AdminComponent} from "./admin/admin.component"
import {EnvironnementComponent} from "./environnement/environnement.component"
import {LoginComponent} from './login/login.component';
import {AuthGuard} from "./service/auth-guard.service"


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'mon-environnement', component: EnvironnementComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
