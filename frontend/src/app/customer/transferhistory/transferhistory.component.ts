import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Transfer } from '../../models/transfer';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-transferhistory',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './transferhistory.component.html',
  styleUrl: './transferhistory.component.css'
})
export class TransferhistoryComponent implements OnInit{
  transfers:Transfer[]=[];
  constructor(private service:CustomerService){}
  ngOnInit(): void {
    this.loadTransferHistory();
  }
  loadTransferHistory()
  {
    this.service.transferHistory().subscribe({next:(data)=>
    {
      this.transfers=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unable to load transfers");
    }
    });
  }

}
