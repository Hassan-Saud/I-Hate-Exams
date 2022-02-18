/*	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com
*/


package Controller;
import View.*;
import java.io.*;
import java.util.*;
public class LoginDatabase implements Serializable{
	private String name;
	private String password;
	private String email;
	private String session;
	private String department;
	private String rollNo;
	private String authority;
	public LoginDatabase(String name, String password, String email, String session, String department, String rollNo, String authority){
		this.name=name;
		this.password=password;
		this.email=email;
		this.session=session;
		this.department=department;
		this.rollNo=rollNo;
		this.authority=authority;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;

	}
	public String getEmail(){
		return this.email;
	}
	public String getSession(){
		return this.session;
	}
	public String getDepartment(){
		return this.department;
	}
	public String getRollNo(){
		return this.rollNo;
	}
	public String getAuthority(){
		return this.authority;
	}
}