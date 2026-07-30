import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../models/customer';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './customerdashboard.component.html',
  styleUrl: './customerdashboard.component.css'
})
export class CustomerdashboardComponent implements OnInit{
  customer!:Customer;
  balance!:number;
  constructor(private service:CustomerService,private router:Router){}
  ngOnInit(): void {
    this.loaddashboard();
  }
  loaddashboard()
  {
    this.service.viewProfile().subscribe({next:(data)=>
    {
      this.customer=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
    this.service.checkBalance().subscribe({next:(data)=>
    {
      this.balance=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
  }
  logout()
  {
    localStorage.clear();
    this.router.navigate(['/customerlogin']);
  }
  

}
