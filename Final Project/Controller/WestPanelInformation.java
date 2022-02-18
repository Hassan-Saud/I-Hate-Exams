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
public class WestPanelInformation implements Serializable{
	private String[] texts;
	public WestPanelInformation(String[] text){
		this.texts=new String[5];
		for(int num=0;num<this.texts.length;num++){
			this.texts[num]=text[num];
		}
	}
	public String[] getTexts(){
		return this.texts;
	}
	
	
	
}