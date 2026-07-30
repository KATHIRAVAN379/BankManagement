import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-transfermoney',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './transfermoney.component.html',
  styleUrl: './transfermoney.component.css'
})
export class TransfermoneyComponent {
  constructor(private service:CustomerService){}
  toAccount:number=0;
  amount:number=0;
  transferMoney()
  {
    if(this.toAccount<=0)
    {
      alert("enter valid accountNO");
      return;
    }
    if(this.amount<=0)
    {
      alert("amount must be greater than zero");
      return;
    }
    this.service.transferMoney(this.toAccount,this.amount).subscribe({next:(data)=>
    {
      alert("transfer successfully");
      console.log(data);
      this.amount=0;
      this.toAccount=0;
    },error:(err)=>
    {
      console.error(err);
      if(err.error)
      {
        alert(err.error);
      }
      else{
        alert("unable to transfer");
      }
    }
    });
  }
}
