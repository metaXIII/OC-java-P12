import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./index/index.component"
import {AdminComponent} from "./admin/admin.component"
import {EnvironnementComponent} from "./environnement/environnement.component"
import {LoginComponent} from './login/login.component';
import {AuthGuard} from "./service/auth-guard.service"
import {ArticleComponent} from "./article/article.component"
import {NewArticleComponent} from "./new-article/new-article.component"
import {ProfilComponent} from "./profil/profil.component"


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'mon-environnement', component: EnvironnementComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
  {path: 'admin/articles', component: ArticleComponent, canActivate: [AuthGuard]},
  {path: 'admin/create-article', component: NewArticleComponent, canActivate: [AuthGuard]},
  {path: 'admin/profil', component: ProfilComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
