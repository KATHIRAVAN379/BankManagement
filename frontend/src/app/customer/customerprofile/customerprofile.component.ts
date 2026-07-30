import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../models/customer';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-customerprofile',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './customerprofile.component.html',
  styleUrl: './customerprofile.component.css'
})
export class CustomerprofileComponent implements OnInit{
  customer!:Customer;
  isEdit:boolean=false;
  constructor(private service:CustomerService){}
  ngOnInit(): void {
    this.loadprofile();
  }
  loadprofile()
  {
    this.service.viewProfile().subscribe({next:(data)=>
    {
      this.customer=data;
    },error:(err)=>
    {
      console.error(err);
      alert('unable to view profile');
    }
    });
  }
  enableEdit()
  {
    this.isEdit=true;
  }
  cancelEdit()
  {
    this.isEdit=false;
    this.loadprofile();
  }
  updateprofile()
  {
    this.service.updateProfile(this.customer).subscribe({next:(data)=>
    {
      this.customer=data;
      this.isEdit=false;
      alert("profile updated succfully");
    },error:(err)=>
    {
      console.error(err);
      alert("unable to edit or update");
    }
    });
  }

}
