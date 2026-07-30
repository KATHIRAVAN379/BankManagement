import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthenService } from '../authen.service';

@Component({
  selector: 'app-customerlogin',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './customerlogin.component.html',
  styleUrl: './customerlogin.component.css'
})
export class CustomerloginComponent {

  accountNo: number = 0;
  password: string = "";

  constructor(
    private auth: AuthenService,
    private router: Router
  ) { }

  login() {

    const customer = {
      accountNo: this.accountNo,
      password: this.password
    };

    this.auth.customerLogin(customer).subscribe({

      next: (token) => {

        localStorage.setItem("token", token);
        localStorage.setItem("role", "ROLE_CUSTOMER");

        this.router.navigate(['/customerdashboard']);

      },

      error: () => {

        alert("Invalid Account Number or Password");

      }

    });

  }

}