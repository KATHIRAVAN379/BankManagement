import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-deposit',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './deposit.component.html',
  styleUrl: './deposit.component.css'
})
export class DepositComponent {
  amount:number=0;
  constructor(private service:CustomerService){}
  deposit()
  {
    if(this.amount<=0)
    {
      alert("amount must be greater then zero");
      return;
    }
    this.service.deposit(this.amount).subscribe({next:()=>
    {
      alert("deposited Successfully");
    },error:(err)=>
    {
      console.error(err);
      alert("unable to deposit");
    }
    });
  }
  clear()
  {
    this.amount=0;
  }

}
