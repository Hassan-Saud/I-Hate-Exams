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
public class Question implements Serializable{
	private String question;
	private String[] options;
	private int correctOption;
	public Question(String question, String[] options, int correct){
		this.question=question;
		this.options=options;
		this.correctOption=correct;
	}
	public String getQuestion(){
		return this.question;
	}
	public String[] getOptions(){
		return this.options;
	}
	public int getCorrectOption(){
		return this.correctOption;
	}
}