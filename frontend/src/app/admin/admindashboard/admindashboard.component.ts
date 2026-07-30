import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-admindashboard',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit{

  totalCustomers = 0;
  totalAccounts = 0;
  totalTransactions = 0;
  totalBankBalance=0;

  recentTransactions: any[] = [];

  constructor(private service:AdminService,private router: Router) {}
  ngOnInit():void
  {
    this.loadDashboard();
  }
  loadDashboard()
  {
    this.service.totalCustomers().subscribe({next:(data)=>
    {
      console.log("customer:",data);
      this.totalCustomers=data;
    },error:(err)=>{
      console.error(err);
    }
    });
    this.service.totalAccounts().subscribe({next:(data)=>
    {
      this.totalAccounts=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
    this.service.totalBankBalance().subscribe({next:(data)=>
    {
      this.totalBankBalance=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
    this.service.totalTransactions().subscribe({next:(data)=>
    {
      this.totalTransactions=data;
    },error:(err)=>
    {
      console.error(err);
    }
    });
    this.service.getAllTransactions().subscribe({next:(data)=>
    {
      this.recentTransactions=data.slice().reverse().slice(0,5);
    },error:(err)=>
    {
      console.error(err);
    }
    });
  }
  logout() {
    localStorage.clear();
    this.router.navigate(['/adminlogin']);
  }

}