import { ApiService } from './../services/api.service';
import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormControl,FormGroup,Validator, Validators} from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm!:FormGroup;
  submitted:boolean=false;
  constructor(private formBuilder:FormBuilder, private router: Router , private ApiService:ApiService){}



  ngOnInit(){
    this.loginForm=this.formBuilder.group({
      email:["",[Validators.required,Validators.email]],
      password:["",[Validators.required,Validators.minLength(6)]]
    }
    )

  }

  get f(){
    return this.loginForm.controls;
  }

  onSubmit(){
    
    this.submitted = true;
    console.log(this.loginForm.value)

    this.ApiService.login(this.loginForm.value).subscribe((res)=>{
      console.log(res);
      
    this.router.navigate(['/home'])

    })



    
  }


  onReset() {
    this.submitted = false;
    this.loginForm.reset();
}

signup(){
  this.router.navigate(["signup"])

}




}
