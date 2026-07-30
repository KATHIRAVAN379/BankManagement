import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';
import { AdminService } from '../../services/admin.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-customerlist',
  standalone: true,
  imports: [CommonModule,RouterLink,FormsModule],
  templateUrl: './customerlist.component.html',
  styleUrl: './customerlist.component.css'
})
export class CustomerlistComponent implements OnInit{

  customers:Customer[]=[];
  customerId:number=0;
  constructor(private service:AdminService,private router:Router){}
  ngOnInit(): void {
    this.loadCustomers();
  }
  loadCustomers()
  {
    this.service.getAllCustomers().subscribe({next:(data)=>
    {
      this.customers=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unable to load customer");
    }
    });
  }
  editCustomer(customerId:number):void
  {
    this.router.navigate(['/addcustomer'],
      {queryParams:{id:customerId}
    });
  }
  deleteCustomer(customerId:number):void
  {
    if(confirm("Are you sure"))
    {
      this.service.deleteCustomer(customerId).subscribe({next:()=>
      {
        alert("customer deleted successfully");
        this.loadCustomers();
      },error:(err)=>
      {
        console.error(err);
        alert("unable to delete");
      }
      });
    }
  }
  search()
  {
    this.service.getCustomerById(this.customerId).subscribe({next:(data)=>
    {
      this.customers=[data];
    }
    })
  }

}
