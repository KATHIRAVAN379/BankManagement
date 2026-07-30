import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';
import { Account } from '../models/account';
import { Transaction } from '../models/transaction';
import { Transfer } from '../models/transfer';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminurl="http://localhost:8080/admin";
  constructor(private http:HttpClient) { }
  createCustomer(customer:Customer)
  {
    return this.http.post<Customer>(`${this.adminurl}/customer`,customer);
  }
  updateCustomer(customerId:number,customer:Customer)
  {
    return this.http.put<Customer>(`${this.adminurl}/customer/${customerId}`,customer);
  }
  deleteCustomer(customerId:number)
  {
    return this.http.delete(`${this.adminurl}/customer/${customerId}`,{responseType:'text'});
  }
  getCustomerById(customerId:number)
  {
    return this.http.get<Customer>(`${this.adminurl}/customer/${customerId}`);
  }
  getAllCustomers()
  {
    return this.http.get<Customer[]>(`${this.adminurl}/customer`);
  }
  createAccount(customerId:number,accountType:string,balance:number)
  {
    return this.http.post<Account>(`${this.adminurl}/account/${customerId}/${accountType}/${balance}`,{});
  }
  getAccountByNumber(accountNo:number)
  {
    return this.http.get<Account>(`${this.adminurl}/account/${accountNo}`)
  }
  activateAccount(accountNo:number)
  {
    return this.http.put<Account>(`${this.adminurl}/account/activate/${accountNo}`,{});
  }
  freezeAccount(accountNo:number)
  {
    return this.http.put<Account>(`${this.adminurl}/account/freeze/${accountNo}`,{});
  }
  closeAccount(accountNo:number)
  {
    return this.http.put<Account>(`${this.adminurl}/account/close/${accountNo}`,{});
  }
  resetPassword(accountNo:number)
  {
    return this.http.put(`${this.adminurl}/account/reset/${accountNo}`,{},{responseType:'text'});
  }
  checkBalance(accountNo:number)
  {
    return this.http.get<number>(`${this.adminurl}/account/balance/${accountNo}`);
  }
  getAllAccounts()
  {
  return this.http.get<Account[]>(`${this.adminurl}/accounts`);
  }
  getTransactionByAccount(accountNo:number)
  {
    return this.http.get<Transaction[]>(`${this.adminurl}/transaction/${accountNo}`);
  }
  getAllTransactions()
  {
    return this.http.get<Transaction[]>(`${this.adminurl}/transaction`);
  }
  getAllTransfers()
  {
    return this.http.get<Transfer[]>(`${this.adminurl}/transfer`);
  }
  getTransfersByAccount(accountNo:number)
  {
    return this.http.get<Transfer[]>(`${this.adminurl}/transfer/${accountNo}`);
  }
  totalCustomers()
  {
    return this.http.get<number>(`${this.adminurl}/totalCustomers`);
  }
  totalAccounts()
  {
    return this.http.get<number>(`${this.adminurl}/totalAccounts`);
  }
  totalTransactions()
  {
    return this.http.get<number>(`${this.adminurl}/totalTransactions`);
  }
  totalBankBalance()
  {
    return this.http.get<number>(`${this.adminurl}/totalBankBalance`);
  }
}
