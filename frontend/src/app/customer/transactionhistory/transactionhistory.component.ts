import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Transaction } from '../../models/transaction';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-transactionhistory',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './transactionhistory.component.html',
  styleUrl: './transactionhistory.component.css'
})
export class TransactionhistoryComponent implements OnInit{
  transactions:Transaction[]=[];
  constructor(private service:CustomerService){}
  ngOnInit(): void {
    this.loadTransactionHistory();
  }
  loadTransactionHistory()
  {
    this.service.transactionHistory().subscribe({next:(data)=>
    {
      this.transactions=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unalbe to load");
    }
    });
  }
}
