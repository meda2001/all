import { Injectable } from "@angular/core";
import {
    ActivatedRouteSnapshot,
    CanActivate,
    Router,
    RouterStateSnapshot,
    UrlTree
} from "@angular/router";
import { ApiService } from "../services/api.service";
  
@Injectable()
export class MyAuthGuard implements CanActivate {
    constructor(
      private apiService:ApiService,
        private router: Router) { }
    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): boolean | Promise<boolean> {
        var isAuthenticated = this.apiService.isAuthenticated();
        if (!isAuthenticated) {
          
            
            return true
        }
        else{
          this.router.navigate(['/login']);
          return false;

        }
        
    }


}