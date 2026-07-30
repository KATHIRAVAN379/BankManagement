# 🏦 Bank Management System

A **Full Stack Bank Management System** developed using **Angular**, **Spring Boot**, **Spring Security**, **JWT Authentication**, **Hibernate (JPA)**, and **MySQL**. The application provides secure banking operations through separate **Admin** and **Customer** modules with a responsive Angular frontend and RESTful Spring Boot backend.

---

## 📌 Project Overview

This project is designed to automate banking operations by providing secure and efficient management of customers, accounts, and financial transactions. It follows a layered architecture with Angular as the frontend, Spring Boot as the backend, and MySQL as the database.

---

# 🚀 Features

## 👨‍💼 Admin Module

- Secure Admin Login
- Dashboard
- Customer Management
  - Add Customer
  - Update Customer
  - Delete Customer
  - View Customers
- Account Management
  - Create Account
  - Update Account
  - Delete Account
  - View Accounts
- Transaction Management
- Transfer Management
- Logout

---

## 👤 Customer Module

- Secure Customer Login
- Dashboard
- View Profile
- Update Profile
- Check Balance
- Deposit Money
- Withdraw Money
- Transfer Money
- Transaction History
- Transfer History
- Change Password
- Logout

---

# 🔐 Security Features

- Spring Security
- JWT Authentication
- BCrypt Password Encryption
- Protected REST APIs
- Role-Based Authorization
- Secure Login Authentication
- Password Hashing
- Session Management using JWT Token

---

# 🛠️ Technology Stack

## Frontend

- Angular
- TypeScript
- HTML5
- CSS3
- RxJS

## Backend

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- REST APIs
- JWT Authentication

## Database

- MySQL

## Build Tool

- Maven

## IDE

- VS Code
- Eclipse IDE

## Version Control

- Git
- GitHub

---

# 📂 Project Structure

```
BankManagement
│
├── frontend
│   ├── src
│   ├── angular.json
│   ├── package.json
│   └── ...
│
├── backend
│   ├── src
│   ├── pom.xml
│   ├── mvnw
│   └── ...
│
└── README.md
```

---

# 🗄️ Database

### Tables

- Admin
- Customer
- Account
- Transaction
- Transfer

---

# 🔄 Application Workflow

```
             User
               │
               ▼
      Angular Frontend
               │
        HTTP REST API
               │
               ▼
        Spring Boot API
               │
      Spring Security
               │
      JWT Authentication
               │
      Hibernate (JPA)
               │
               ▼
          MySQL Database
```

---

# 📸 Application Screenshots

## Home Page

*(Add Screenshot)*

---

## Admin Login

*(Add Screenshot)*

---

## Admin Dashboard

*(Add Screenshot)*

---

## Customer Management

*(Add Screenshot)*

---

## Account Management

*(Add Screenshot)*

---

## Customer Dashboard

*(Add Screenshot)*

---

## Customer Profile

*(Add Screenshot)*

---

## Deposit

*(Add Screenshot)*

---

## Withdraw

*(Add Screenshot)*

---

## Transfer Money

*(Add Screenshot)*

---

## Transaction History

*(Add Screenshot)*

---

## Transfer History

*(Add Screenshot)*

---

# ⚙️ Installation

## Clone Repository

```bash
git clone https://github.com/KATHIRAVAN379/BankManagement.git
```

---

## Backend Setup

```bash
cd backend
```

Configure MySQL database credentials in:

```
application.properties
```

Run the Spring Boot application.

Default Backend URL

```
http://localhost:8080
```

---

## Frontend Setup

```bash
cd frontend
npm install
ng serve
```

Default Frontend URL

```
http://localhost:4200
```

---

# 📚 REST APIs

### Admin APIs

- Login
- Customer CRUD
- Account CRUD
- Transaction APIs
- Transfer APIs

### Customer APIs

- Login
- View Profile
- Update Profile
- Check Balance
- Deposit
- Withdraw
- Transfer Money
- Transaction History
- Transfer History
- Change Password

---

# 🔮 Future Enhancements

- Reports Module
- PDF Report Export
- Excel Report Export
- Email Notifications
- Dashboard Analytics
- Docker Deployment
- Cloud Deployment (AWS/Azure)

---

# 👨‍💻 Author

## Kathiravan K

**GitHub**

https://github.com/KATHIRAVAN379

---

# ⭐ Support

If you found this project useful, please consider giving it a ⭐ on GitHub.
