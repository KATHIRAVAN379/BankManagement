# 🏦 Full Stack Bank Management System

A Full Stack Bank Management System developed using **Angular**, **Spring Boot**, **Hibernate (JPA)**, and **MySQL**. This application provides secure banking operations through separate **Admin** and **Customer** modules with a responsive Angular frontend and RESTful Spring Boot backend.

---

## 🚀 Features

### 👨‍💼 Admin Module
- Admin Login
- Dashboard
- Customer Management (Add, Update, Delete, View)
- Account Management
- Transaction Management
- Transfer Management
- Reports *(In Progress)*
- Logout

### 👤 Customer Module
- Customer Login
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

## 🛠️ Technology Stack

### Frontend
- Angular
- TypeScript
- HTML5
- CSS3
- RxJS

### Backend
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- REST APIs

### Database
- MySQL

### Tools
- VS Code
- Eclipse IDE
- Maven
- Git
- GitHub

---

## 📂 Project Structure

```
BankManagement/
│
├── frontend/
│   ├── src/
│   ├── angular.json
│   ├── package.json
│   └── ...
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
└── README.md
```

---

## 📌 Modules

### Admin
- Customer CRUD
- Account CRUD
- Transaction Monitoring
- Transfer Monitoring
- Dashboard
- Reports

### Customer
- Deposit
- Withdraw
- Transfer
- Transaction History
- Transfer History
- Profile Management
- Password Management

---

## 🗄️ Database

**MySQL**

Major Tables

- Admin
- Customer
- Account
- Transaction
- Transfer

---

## 🔄 Application Workflow

```
Admin/Customer Login
        │
        ▼
Angular Frontend
        │
 REST API Calls
        │
        ▼
Spring Boot Backend
        │
Hibernate (JPA)
        │
        ▼
MySQL Database
```

---

## ⚙️ Installation

### 1. Clone Repository

```bash
git clone https://github.com/KATHIRAVAN379/BankManagement.git
```

### 2. Backend

```bash
cd backend
```

Configure the MySQL database in:

```
application.properties
```

Run the Spring Boot application.

---

### 3. Frontend

```bash
cd frontend
npm install
ng serve
```

Angular runs at

```
http://localhost:4200
```

Spring Boot runs at

```
http://localhost:8080
```

---

## 📸 Screenshots

### Home Page

*(Add Screenshot)*

### Admin Dashboard

*(Add Screenshot)*

### Customer Dashboard

*(Add Screenshot)*

### Deposit

*(Add Screenshot)*

### Withdraw

*(Add Screenshot)*

### Transfer Money

*(Add Screenshot)*

### Transaction History

*(Add Screenshot)*

---

## 🔮 Future Enhancements

- Reports Module
- PDF Export
- Excel Export
- Spring Security
- JWT Authentication
- BCrypt Password Encryption
- Email Notifications
- Dashboard Charts

---

## 👨‍💻 Author

**Kathiravan K**

- GitHub: https://github.com/KATHIRAVAN379

---

## ⭐ If you like this project

Please consider giving this repository a **Star ⭐**.
