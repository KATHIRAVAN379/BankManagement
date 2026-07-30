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

<img width="505" height="488" alt="image" src="https://github.com/user-attachments/assets/c99e70fa-77b8-4cdf-b066-805eb67e8923" />


---

## Admin Login

<img width="326" height="384" alt="image" src="https://github.com/user-attachments/assets/7ec9a34d-9c20-423c-9692-6403dfcffa00" />


---

## Admin Dashboard

<img width="937" height="469" alt="image" src="https://github.com/user-attachments/assets/bf6fa5b4-8866-494f-8dca-a47df471629a" />


---

## Customer Management

<img width="925" height="331" alt="image" src="https://github.com/user-attachments/assets/42ec8cee-87ce-4a88-82ab-ddec685cb6d8" />


---

## Account Management

*<img width="926" height="315" alt="image" src="https://github.com/user-attachments/assets/84053025-c988-4bda-be1b-22670af3c2ec" />

---

## Transaction Management
<img width="916" height="485" alt="image" src="https://github.com/user-attachments/assets/234a6959-b657-4627-853c-2712b3a8e549" />

---
##Transfer Management
<img width="918" height="360" alt="image" src="https://github.com/user-attachments/assets/08b5c6d2-f0a8-47df-9ea4-507b64c12b73" />

---

##Customer Login

<img width="415" height="452" alt="image" src="https://github.com/user-attachments/assets/9d4c3324-6e4f-4134-a9fa-cd74de1c9b8b" />

--


## Customer Dashboard

<img width="924" height="503" alt="image" src="https://github.com/user-attachments/assets/5a0023bc-6006-496c-9fc5-71b99c0efe49" />


---

## Customer Profile

<img width="845" height="379" alt="image" src="https://github.com/user-attachments/assets/d93790b8-d214-4071-ba5a-1a9f015fad1c" />


---

## Deposit

<img width="724" height="428" alt="image" src="https://github.com/user-attachments/assets/ad604e4d-d365-4db3-a379-edb6cd977a62" />


---

## Withdraw

<img width="617" height="404" alt="image" src="https://github.com/user-attachments/assets/cce26410-8928-47bb-91ff-31242510c434" />


---

## Transfer Money

<img width="614" height="451" alt="image" src="https://github.com/user-attachments/assets/3757e34a-6c57-44d1-9aed-1224e8e79b0b" />


---

## Transaction History

<img width="761" height="397" alt="image" src="https://github.com/user-attachments/assets/4b260769-bb77-4b25-96a0-7b109542ca0d" />


---

## Transfer History

<img width="759" height="283" alt="image" src="https://github.com/user-attachments/assets/5b0b9d0b-782c-4de8-abc9-0b4f1710883f" />

---

##Change Password

<img width="608" height="449" alt="image" src="https://github.com/user-attachments/assets/89014e88-7e81-4b1a-8fac-21ffba34e30e" />


--

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
