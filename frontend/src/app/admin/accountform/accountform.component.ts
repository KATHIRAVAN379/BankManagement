import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-accountform',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './accountform.component.html',
  styleUrl: './accountform.component.css'
})
export class AccountformComponent {
  customerId:number=0;
  accountType:string='';
  balance:number=0;
  constructor(private service:AdminService,private router:Router){}
  createAccount():void
  {
    if(this.customerId<=0 || this.accountType.trim()===''|| this.balance<0)
    {
      alert("enter valid details");
      return;
    }
    this.service.createAccount(this.customerId,this.accountType,this.balance).subscribe({next:(data)=>
    {
      alert('account created successfully');
      console.log(data);
      this.resetForm();
      this.router.navigate(['/accounts']);
    },error:(err)=>
    {
      console.error(err);
      alert("unabled to create account");
    }
    });
  }
  resetForm():void
  {
    this.customerId=0;
    this.accountType='';
    this.balance=0;
  }
  
}
