package com.bank.advancebank.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="admin")
public class Adminentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String phone;
	private String role;
	private LocalDateTime createdAt;
	public Adminentity()
	{
		
	}
	public Adminentity(int adminId,String username,String password,String fullname,
                String email,String phone,String role,LocalDateTime createdAt)
	{
		this.adminId=adminId;
		this.username=username;
		this.password=password;
		this.fullname=fullname;
		this.email=email;
		this.phone=phone;
		this.role=role;
		this.createdAt=createdAt;
	}	
	public void setAdminId(int adminId)
	{
		this.adminId=adminId;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setFullname(String fullname)
	{
		this.fullname=fullname;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public void setRole(String role)
	{
		this.role=role;
	}
	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt=createdAt;
	}
	public int getAdminId()
	{
		return adminId;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getFullname()
	{
		return fullname;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getRole()
	{
		return role;
	}
	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}
}
