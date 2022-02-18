/*	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com
*/

package Controller;
import View.*;
import java.util.*;
import java.io.*;
public class ResultRecord implements Serializable{
	private String name;
	private String rollNo;
	private String department;
	private String email;
	private String session;
	private double result;
	public ResultRecord(String name,String rollNo,String department,String session,String email, double result){
		this.name=name;
		this.rollNo=rollNo;
		this.department=department;
		this.session=session;
		this.email=email;
		this.result=result;
	}
	public String getName(){
		return this.name;
	}
	public String getRollNo(){
		return this.rollNo;
	}
	public String getDepartment(){
		return this.department;
	}
	public String getSession(){
		return this.session;
	}
	public double getResult(){
		return this.result;
	}
	public String getEmail(){
		return this.email;
	}
	
}