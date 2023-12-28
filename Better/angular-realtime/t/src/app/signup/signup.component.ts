import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  signUp:FormGroup = new FormGroup({});

  constructor(private router:Router , public formBuilder:FormBuilder){}


  ngOnInit(){

    this.signUp = this.formBuilder.group({
      name: new FormControl(null,[Validators.required]),
      email: new FormControl(null,[Validators.required,Validators.email]),
      cemail: new FormControl(null,[Validators.required,Validators.email]),
      password: new FormControl(null,[Validators.required]),
      cpassword: new FormControl(null,[Validators.required])
    })

  }

  onSubmit(){
    console.log(this.signUp.value);
  }

  Reset(){
    this.signUp.reset();
  }

  login(){
    this.router.navigate(["login"])
  }

}
