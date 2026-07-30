import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink,RouterModule],
  templateUrl: './changepassword.component.html',
  styleUrl: './changepassword.component.css'
})
export class ChangepasswordComponent {
  oldPassword:string='';
  newPassword:string='';
  confirmPassword:string='';
  constructor(private service:CustomerService,private router:Router){}
  changePassword()
  {
    if(this.oldPassword.trim()==='' || this.newPassword.trim()==='' 
    || this.confirmPassword.trim()==='')
    {
      alert("fill all the field");
      return;
    }
    if(this.confirmPassword!==this.newPassword)
    {
      alert("new and confirm password ar not same");
      return;
    }
    if(confirm("Are you sure to change password"))
    {
      this.service.changePassword(this.oldPassword,this.newPassword).subscribe({next:()=>
      {
        alert("password changes successfully");
        this.router.navigate(['/customerdashboard']);
      },error:(err)=>
        {
          console.error(err);
          alert("unable to change password");
        }
      });
    }
  }
  reset()
  {
    this.oldPassword='';
    this.newPassword='';
    this.confirmPassword='';
  }

}
