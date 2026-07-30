import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';
import { Customer } from '../../models/customer';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-updateprofile',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './updateprofile.component.html',
  styleUrl: './updateprofile.component.css'
})
export class UpdateprofileComponent implements OnInit{
  customer!:Customer;
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
      alert("unable to load profile");
    }
    });
  }
  updateprofile()
  {
    this.service.updateProfile(this.customer).subscribe({next:(data)=>
    {
      this.customer=data;
    },error:(err)=>
    {
      console.error(err);
      alert("unable to update profile");
    }
    });
  }
}
