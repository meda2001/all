import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ApiService {


  constructor(private http:HttpClient) { }

  isLoggedIn: boolean = false;

  login(data: any){
    this.isLoggedIn=true;
    return this.http.post('http://localhost:8080/api/v1//userLogin',data);
    
  }

  signup(user:any){
    return this.http.post('http://localhost:8080/signup', user)
  }


  isAuthenticated(): boolean {
    return this.isLoggedIn;
  }
}
