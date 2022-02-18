This Project is made by:
	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com

Course Name: Object Oriented Programming(lab).

Submitted to: Mr. Asjid Ayub.

Project Name: Quiz Organizer.

There are 12 Classes named as follows:

	1-EastComment.java 		--> To hold the Comments that the teacher will save for the students to convey a Small Note about the Test.
	2-GeneralLogin.java      	--> Application Execution starts at the this class. Login Page will appear. Teacher will login from "Teacher" Portal and Student will Login from "Student" Portal.
		2.1- Login.java		--> Application Execution starts at the this class. Login Page will appear. Teacher will login from "Teacher" Portal and Student will Login from "Student" Portal.
	3-LoginDatabase.java		--> This class is not directly invloved in GUI. Its object will contain the user data like UserName, Passwords, Email etc. A separate binary file will be created for every separate user(Teacher/Student). This file contains the serialized-object of this class. 
	4-PasswordChange.java		--> This class contains necessary information and Credentails for the User to Change his account password. It is also dependent on binary files.
	5-Question.java			--> This class is not directly involved in GUI. Its object will contain the Questions saved by the Teacher. There will be a separate object of this class for every separate Question. All the Questions are then saved in an ArrayList and then the ArrayList is serialized in the binary file.
	6-ResultRecord.java		--> This class is not directly invloved in GUI. Its objects conatins the Marks information of every Student. Then different Objects of this class are serialized in the Binary File.
	7-Student.java			--> This class is Designed for Student ID. Student will enter in this page and take the quiz. Every Student will have its Information already displayed. Like Name, rollNo, Email, Department, Session.
	8-StudentSignUp.java		--> This class is designed for Students to make their IDs. Students will SIGN UP from in here. Login Credientials will be provided automatically.
	9-Teacher4.java			--> This class is designed for Teachers to compose and upload Quiz. Necessary controls and navigations are provided in here.
	10-TeacherChoice.java		--> This class is designed for teachers to make a choice between "Compose Quiz" and "View Result". "View Result" will provide the result of all the students that have taken the Quiz.
	11-TeacherSignUp.java		--> This class is designed for teachers to make their IDs. Teachers will SIGN up from in here. Login credentials will be provided automatically.
	12-WestPanelInformation.java	--> This class is not directly Invloved in the GUI. Its object stores the Information to display for the Quiz, like Total Marks, Marks Per Question, Total Question, Course Name etc. It objects will be serialized in the binary file.

"View" named directory contains all the GUI based java files. "Controller" named directory contains all the supporting files which are directly related to the files.
Objects of these files are stored in the binary files throug Serialization.
"Database" named directory contains all the files. Every new file made will be contained in this directory. It serves as the database for the Application.

All the supporting files are made BINARY ENCODED so that the files may not be visited from outside the code. Files end with ".dat" extension.
There is a Directory named "Pictures". It contains all the Pictures to be displayed in the GUI designs. 
In addition, There are some private inner classes for the EVENT-DRIVEN PROGRAMMING. Inner Classes implement the INTERFACES to Listen the Events Fired by the GUI-Components.
Start the Application from the "Main.java" file. This file is the Starting point of the Application. No need to compile the any file. All the classes are very well compiled.
Just run the application using "java Main" command on command prompt.


PLEASE DO NOT REPLACE, RENAME the files or any of its CONTENTS. ALL THE CLASSES AND FILES ARE VERY DEEPLY INTERLINKED.
//next line applies to the previous version of this program. now you just need to execute the file named Main.java
/*JUST COMBINE THE DIRECTORIES NAMED "View" AND "CONTROLLER" TO SUCCESSFULLY COMPLIE AND RUN ALL THE FILES.*/

I, Hassan Saud, Solemenly admit that the code used in the PROJECT is totally and completely mine.
Every single line, word, letter, number or phrase is absolutely and entirly my personal work/property and not stolen or plagiarised.
If there is something that resembles someone else's code or work or someone claims it his work, consider it a completely and entirely a co-incidence. 





