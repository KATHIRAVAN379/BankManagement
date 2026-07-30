import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Customer } from '../../models/customer';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-customerform',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './customerform.component.html',
  styleUrl: './customerform.component.css'
})
export class CustomerformComponent implements OnInit{
  customer:Customer={} as Customer;
  isEdit=false;
  customerId=0;
  constructor(private service:AdminService,private router:Router,private route:ActivatedRoute){}
  ngOnInit():void
  {
    this.route.queryParams.subscribe(params=>
    {
      console.log(params);
      if(params['id'])
      {
        this.isEdit=true;
        this.customerId=+params['id'];
        console.log("Customer ID:", this.customerId);
        this.loadCustomer();
      }
    }
    );
  }
  addCustomer()
  {
    this.service.createCustomer(this.customer).subscribe({next:()=>
    {
      alert("customer created");
      this.router.navigate(['/customers']);
    },error:(err)=>
    {
      console.error(err);
      alert("unable to create customer");
    }
    });
  }
  updateCustomer()
  {
    this.service.updateCustomer(this.customerId,this.customer).subscribe({next:()=>
    {
      alert("updated customer");
      this.router.navigate(['/customers']);
    },error:(err)=>
    {
      console.error(err);
      alert("unable to update customer");
    }
    });
  }
  loadCustomer()
  {
    this.service.getCustomerById(this.customerId).subscribe({next:(data)=>
    {
      this.customer=data;
    },error:(err)=>
    {
      console.error(err);
      alert("customer not found");
    }
    });
  }
  saveCustomer()
  {
    if(this.isEdit)
    {
      this.updateCustomer();
    }
    else{
      this.addCustomer();
    }
  }
  resetForm()
  {
    this.customer={} as Customer;
  }

}
