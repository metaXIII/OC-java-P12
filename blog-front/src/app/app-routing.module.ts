import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IndexComponent} from "./index/index.component"
import {AdminComponent} from "./admin/admin.component"
import {UserService} from "./user.service"
import {Environment} from "@angular/compiler-cli/src/ngtsc/typecheck/src/environment"
import {EnvironnementComponent} from "./environnement/environnement.component"


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'mon-environnement', component: EnvironnementComponent},
  {path: 'admin', component: AdminComponent, canActivate: [UserService]},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
