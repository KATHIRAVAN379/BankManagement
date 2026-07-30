import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AuthenService {

  private authurl = 'http://localhost:8080/auth';
  constructor(private http: HttpClient) { }
  adminLogin(admin:any)
  {
    return this.http.post(`${this.authurl}/adminLogin`, admin,{responseType:'text'});
  }
  customerLogin(customer:any)
  {
    return this.http.post(`${this.authurl}/customerLogin`,customer,{responseType:'text'});
  }

}
