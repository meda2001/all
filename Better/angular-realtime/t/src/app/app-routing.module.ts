import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MyAuthGuard } from './auth/myauth.guard';

const routes: Routes = [
  {
    path:"signup",
    component:SignupComponent,
    
  },
  {
    path:"login",
    component:LoginComponent

  },
  {
    path:"home",
    component:HomeComponent,
    canActivate:[MyAuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
