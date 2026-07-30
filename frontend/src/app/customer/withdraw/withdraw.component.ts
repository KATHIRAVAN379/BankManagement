import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-withdraw',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './withdraw.component.html',
  styleUrl: './withdraw.component.css'
})
export class WithdrawComponent {
  amount:number=0;
  constructor(private service:CustomerService){}
  withdraw()
  {
    if(this.amount<=0)
    {
      alert("amount must be greater then zero");
      return;
    }
    this.service.withdraw(this.amount).subscribe({next:()=>
    {
      alert("withDrawed:"+this.amount);
    },error:(err)=>
    {
      console.error(err);
      alert("unable to withdraw");
    }
    });
  }
  clear()
  {
    this.amount=0;
  }


}
