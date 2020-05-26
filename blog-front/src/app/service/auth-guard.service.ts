import {Injectable} from "@angular/core"
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router"
import {UserService} from "./user.service"

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private userService: UserService, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) {
    if (this.userService.getUser()) {
      return true;
    } else {
      this.router.navigate(['/index']);
    }
  }
}
