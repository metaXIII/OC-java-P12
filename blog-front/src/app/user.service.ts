import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router"

@Injectable()
export class UserService {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!this.isConnected()) {
      this.router.navigate(['index'])
    }
  }

  private isConnected() {
    return true;
  }
}
