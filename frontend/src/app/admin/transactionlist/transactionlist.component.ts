import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

import { AdminService } from '../../services/admin.service';
import { Transaction } from '../../models/transaction';

@Component({
  selector: 'app-transactionlist',
  standalone: true,
  imports: [CommonModule,RouterLink,FormsModule],
  templateUrl: './transactionlist.component.html',
  styleUrl: './transactionlist.component.css'
})
export class TransactionlistComponent implements OnInit{
  constructor(private service:AdminService){}
  transactions:Transaction[]=[];
  accountNo:number=0;
  ngOnInit():void
  {
    this.loadTransactions();
  }
  loadTransactions():void
  {
    this.service.getAllTransactions().subscribe({next:(data)=>
    {
      this.transactions=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unable to load Transactions");
    }
    });
  }
  searchTransactions()
  {
    if(this.accountNo<=0)
    {
      this.loadTransactions();
      return;
    }
    this.service.getTransactionByAccount(this.accountNo).subscribe({next:(data)=>
    {
      this.transactions=data;
      if(data.length===0)
    {
      alert("no transaction found");
    }
    },error:(err)=>
    {
      console.error(err);
      alert("unable to fetch transactions");
    }
    });
  }
  clearSearch():void{
    this.accountNo=0;
    this.loadTransactions();
  }
}
