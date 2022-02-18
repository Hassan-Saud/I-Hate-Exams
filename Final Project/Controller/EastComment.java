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
public class EastComment implements Serializable{
	
	private String comment;       // String to hold the comment eneterd by the teacher.
	public EastComment(String text){
		this.comment=text;
	}
	public String getComment(){   // Methid to return the Comment.
		return this.comment;
	}
}