import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthenService } from '../authen.service';

@Component({
  selector: 'app-adminlogin',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  username: string = '';
  password: string = '';

  rememberMe: boolean = false;
  showPassword: boolean = false;

  loading: boolean = false;
  errorMessage: string = '';

  constructor(
    private authService: AuthenService,
    private router: Router
  ) {}

  login() {

    this.errorMessage = '';

    if (this.username.trim() === '' || this.password.trim() === '') {

      alert('Please enter Username and Password');

      return;

    }

    this.loading = true;

    const loginData = {

      username: this.username,

      password: this.password

    };

    this.authService.adminLogin(loginData).subscribe({

      next: (token: any) => {

        this.loading = false;

        localStorage.setItem('token', token);

        localStorage.setItem('role', 'ROLE_ADMIN');
        this.router.navigate(['/admindashboard']);

      },

      error: (err) => {

        this.loading = false;

        console.error(err);

        this.errorMessage = 'Invalid Username or Password';

        alert(this.errorMessage);

      }

    });

  }

}