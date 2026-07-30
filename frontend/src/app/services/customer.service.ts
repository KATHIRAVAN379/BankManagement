import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';
import { Transaction } from '../models/transaction';
import { Transfer } from '../models/transfer';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  private customerurl="http://localhost:8080/customer";
  constructor(private http:HttpClient) { }
  changePassword(oldPassword:string,newPassword:string)
  {
    return this.http.put(`${this.customerurl}/changePassword/${oldPassword}/${newPassword}`,{},{responseType:'text'});
  }
  viewProfile()
  {
    return this.http.get<Customer>(`${this.customerurl}/viewProfile`);
  }
  updateProfile(customer:Customer)
  {
    return this.http.put<Customer>(`${this.customerurl}/updateProfile`,customer);
  }
  checkBalance()
  {
    return this.http.get<number>(`${this.customerurl}/checkBalance`);
  }
  deposit(amount:number)
  {
  return this.http.post(`${this.customerurl}/deposit/${amount}`,{},{responseType:'text'});
  }
  withdraw(amount:number)
  {
    return this.http.post(`${this.customerurl}/withdraw/${amount}`,{},{responseType:'text'});
  }
  transferMoney(toAccount:number,amount:number)
  {
    return this.http.post(`${this.customerurl}/transferMoney/${toAccount}/${amount}`,{},{responseType:'text'});
  }
  transactionHistory()
  {
    return this.http.get<Transaction[]>(`${this.customerurl}/transactionHistory`);
  }
  transferHistory()
  {
    return this.http.get<Transfer[]>(`${this.customerurl}/transferHistory`);
  }
}