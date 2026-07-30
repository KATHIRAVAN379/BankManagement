import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

import { AdminService } from '../../services/admin.service';
import { Transfer } from '../../models/transfer';
@Component({
  selector: 'app-transferlist',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './transferlist.component.html',
  styleUrl: './transferlist.component.css'
})
export class TransferlistComponent implements OnInit{
  transfers:Transfer[]=[];
  accountNo:number=0;
  constructor(private service:AdminService){}
  ngOnInit(): void {
    this.loadTransfers();
  }
  loadTransfers():void
  {
    this.service.getAllTransfers().subscribe({next:(data)=>
    {
      this.transfers=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unable to load transfers");
    }
    });
  }
  searchTransfers():void
  {
    if(this.accountNo<=0)
    {
      this.loadTransfers();
      return;
    }
    this.service.getTransfersByAccount(this.accountNo).subscribe({next:(data)=>
    {
      this.transfers=data;
      if(data.length===0)
      {
        alert("no transfer found");
      }
    },error:(err)=>
    {
      console.error(err);
      alert("unable to fetch this account transfers");
    }
    });
  }
  clearSearch():void{
    this.accountNo=0;
    this.loadTransfers();
  }

}
