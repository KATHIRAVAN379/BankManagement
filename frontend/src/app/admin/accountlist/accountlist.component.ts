import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {  RouterLink } from '@angular/router';

import { AdminService } from '../../services/admin.service';
import { Account } from '../../models/account';

@Component({
  selector: 'app-accountlist',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './accountlist.component.html',
  styleUrl: './accountlist.component.css'
})
export class AccountlistComponent implements OnInit{
  accounts:Account[]=[];
  accountNo:number=0;

  constructor(private service:AdminService){}
  ngOnInit(): void {
    this.loadAccounts();
  }
  loadAccounts():void
  {
    this.service.getAllAccounts().subscribe({next:(data)=>
    {
      this.accounts=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
  }
  searchAccount():void
  {
    if(this.accountNo<=0)
    {
      this.loadAccounts();
      return;
    }
    this.service.getAccountByNumber(this.accountNo).subscribe({next:(data)=>
    {
      this.accounts=[data];
      alert("account found");
    },error:(err)=>
    {
      console.error(err);
      alert("account not found");
    }
    });
  }
  activateAccount(accountNo:number):void
  {
    this.service.activateAccount(accountNo).subscribe({next:()=>
    {
      alert("account activated");
      this.loadAccounts();
    },error:(err)=>
    {
      console.error(err);
      alert("unable to activated account");
    }
    });
  }
  freeze(accountNo:number):void
  {
    this.service.freezeAccount(accountNo).subscribe({next:()=>
    {
      alert("account freezed");
      this.loadAccounts();
    },error:(err)=>
    {
      console.error(err);
      alert("unable to freeze");
    }
    });
  }
  close(accountNo:number):void
  {
    if(confirm("are you sure to close this account"))
    {
    this.service.closeAccount(accountNo).subscribe({next:()=>
    {
      alert("account closed");
      this.loadAccounts();
    },error:(err)=>
    {
      console.error(err);
      alert("unable to close");
    }
    });
  }
  }
  checkBalance(accountNo:number):void
  {
    this.service.checkBalance(accountNo).subscribe({next:(data)=>
    {
      alert("balance:"+data);
    },error:(err)=>
    {
      console.error(err);
    }
    });
  }
  resetPassword(accountNo:number):void
  {
    this.service.resetPassword(accountNo).subscribe({next:(data)=>
    {
      alert(data);
    },error:(err)=>
    {
      console.error(err);
      alert("unable to reset");
    }
    });
  }
  clearSearch():void
  {
    this.accountNo=0;
    this.loadAccounts();
  }
}
