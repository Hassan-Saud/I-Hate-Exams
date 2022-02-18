/*	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com
*/




package View;
import Controller.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Login1 extends JFrame implements Serializable{
	private Icon[] images;
	private JPanel imagePanel;
	private JButton[] imageButtons;
	private JPanel teacherLoginPanel;
	private JPanel studentLoginPanel;
	private JTextField studentLogin;
	private JPasswordField studentPassword;
	private JTextField teacherLogin;
	private JPasswordField teacherPassword;
	private JButton teacherLoginButton;
	private JButton teacherSignUpButton;
	private JButton studentLoginButton;
	private JButton studentSignUpButton;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel adminPanel;
	private JTextField adminLoginField;
	private JPasswordField adminPasswordField;
	private JButton adminSignUpButton;
	private JButton adminLoginButton;
/* Constructor to build the contenet pane*/

	public Login1(){
		setTitle("Login Page");				// Window title
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());				
		//buildImagePanel();
		buildTeacherLoginPanel();
		buildStudentLoginPanel();
		buildAdminPanel();
		buildCenterPanel();
		buildNorthPanel();
		buildSouthPanel();
		//add(imagePanel,BorderLayout.WEST);
		add(centerPanel,BorderLayout.CENTER);
		add(northPanel,BorderLayout.NORTH);
		add(southPanel,BorderLayout.SOUTH);
		//add(studentLoginPanel);
		setSize(1336,768);
		setVisible(true);
	}


/* Method to build the panel that contains the middle pictures */

	private void buildImagePanel() {


		imagePanel=new JPanel();
		imagePanel.setLayout(new GridLayout(2,1));
		JPanel smallPanel=new JPanel();
		JPanel panel=new JPanel();
		Icon image=new ImageIcon("Pictures/logo long.png");
		JLabel label=new JLabel(image);
		panel.add(label);
		Icon image1=new ImageIcon("Pictures/gcu png logo.png");
		JLabel label1=new JLabel(image1);
		smallPanel.add(label1);
		imagePanel.add(smallPanel);
		imagePanel.add(panel);
		
	}


/* method to build Panel that contains the Login portal for teachers 
   Nested panels are used within this main panel
*/

	private void buildTeacherLoginPanel()  {


		teacherLoginPanel=new JPanel();
		teacherLoginPanel.setLayout(new GridLayout(4,1));
		teacherLogin=new JTextField(20);
		teacherPassword=new JPasswordField(20);
		teacherLoginButton=new JButton("Sign In");
		teacherLoginButton.setBackground(Color.RED);
		teacherLoginButton.setForeground(Color.WHITE);
		teacherLoginButton.setFont(new Font("Dialog",Font.PLAIN,13));
		teacherLoginButton.addActionListener(new TeacherLoginListener());
		teacherSignUpButton=new JButton("Sign Up");
		teacherSignUpButton.setBackground(Color.BLUE);
		teacherSignUpButton.setForeground(Color.WHITE);
		teacherSignUpButton.setFont(new Font("Dialog",Font.PLAIN,13));
		teacherSignUpButton.addActionListener(new TeacherLoginListener());
		Icon image=new ImageIcon("Pictures/logo.png");
		JLabel imageLabel=new JLabel(image);
		JPanel loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(2,1));
		JLabel signLabel=new JLabel("User Name");
		JLabel passwordLabel=new JLabel("Password");
		JPanel panel=new JPanel();
		panel.add(signLabel);
		panel.add(teacherLogin);
		JPanel panel1=new JPanel();
		panel1.add(passwordLabel);
		panel1.add(teacherPassword);
		loginPanel.add(panel);
		loginPanel.add(panel1);
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(teacherLoginButton);
		buttonPanel.add(teacherSignUpButton);
		JLabel label=new JLabel("Teacher Login");
		label.setFont(new Font("Dialog",Font.BOLD,20));
		label.setForeground(Color.BLUE);
		JPanel labelPanel=new JPanel();
		labelPanel.add(label);
		teacherLoginPanel.add(imageLabel);
		teacherLoginPanel.add(labelPanel);
		teacherLoginPanel.add(loginPanel);
		teacherLoginPanel.add(buttonPanel);
		
		
	}


/* Methos to build the Panel that contains the Login portal for students 
   Nested panels are used in within this main panel.
*/

	private void buildStudentLoginPanel()  {

		studentLoginPanel=new JPanel();
		studentLoginPanel.setLayout(new GridLayout(4,1));
		studentLogin=new JTextField(20);
		studentPassword=new JPasswordField(20);
		studentLoginButton=new JButton("Sign In");
		studentLoginButton.setBackground(Color.RED);
		studentLoginButton.setForeground(Color.BLACK);
		studentLoginButton.setFont(new Font("Dialog",Font.PLAIN,13));
		
		studentLoginButton.addActionListener(new StudentLoginListener());
		
		studentSignUpButton=new JButton("Sign Up");
		studentSignUpButton.setBackground(Color.BLUE);
		studentSignUpButton.setForeground(Color.WHITE);
		studentSignUpButton.setFont(new Font("Dialog",Font.PLAIN,13));
		studentSignUpButton.addActionListener(new StudentLoginListener());
		JLabel signLabel=new JLabel("User Name");
		JLabel passwordLabel=new JLabel("Password");
		Icon image=new ImageIcon("Pictures/logo.png");
		JLabel imageLabel=new JLabel(image);
		JPanel loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(2,1));
		JPanel panel=new JPanel();
		panel.add(signLabel);
		panel.add(studentLogin);
		JPanel panel1=new JPanel();
		panel1.add(passwordLabel);
		panel1.add(studentPassword);
		loginPanel.add(panel);
		loginPanel.add(panel1);
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(studentLoginButton);
		buttonPanel.add(studentSignUpButton);
		JLabel label=new JLabel("Student Login");
		label.setFont(new Font("Dialog",Font.BOLD,20));
		label.setForeground(Color.BLUE);
		JPanel labelPanel=new JPanel();
		labelPanel.add(label);
		studentLoginPanel.add(imageLabel);
		studentLoginPanel.add(labelPanel);
		studentLoginPanel.add(loginPanel);
		studentLoginPanel.add(buttonPanel);
	}
	
	
	private void buildAdminPanel(){
		
		
		adminPanel=new JPanel();
		adminPanel.setLayout(new GridLayout(4,1));
		adminLoginField=new JTextField(20);
		adminPasswordField=new JPasswordField(20);
		adminLoginButton=new JButton("Sign In");
		adminLoginButton.setBackground(Color.RED);
		adminLoginButton.setForeground(Color.WHITE);
		adminLoginButton.setFont(new Font("Dialog",Font.PLAIN,13));
		adminLoginButton.addActionListener(new AdminLoginListener());
		adminSignUpButton=new JButton("Sign Up");
		adminSignUpButton.setBackground(Color.BLUE);
		adminSignUpButton.setForeground(Color.WHITE);
		adminSignUpButton.setFont(new Font("Dialog",Font.PLAIN,13));
		adminSignUpButton.addActionListener(new AdminLoginListener());
		Icon image=new ImageIcon("Pictures/logo.png");
		JLabel imageLabel=new JLabel(image);
		JPanel loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(2,1));
		JLabel signLabel=new JLabel("User Name");
		JLabel passwordLabel=new JLabel("Password");
		JPanel panel=new JPanel();
		panel.add(signLabel);
		panel.add(adminLoginField);
		JPanel panel1=new JPanel();
		panel1.add(passwordLabel);
		panel1.add(adminPasswordField);
		loginPanel.add(panel);
		loginPanel.add(panel1);
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(adminLoginButton);
		buttonPanel.add(adminSignUpButton);
		JLabel label=new JLabel("Admin Login");
		label.setFont(new Font("Dialog",Font.BOLD,20));
		label.setForeground(Color.BLUE);
		JPanel labelPanel=new JPanel();
		labelPanel.add(label);
		adminPanel.add(imageLabel);
		adminPanel.add(labelPanel);
		adminPanel.add(loginPanel);
		adminPanel.add(buttonPanel);
		
		
	}
	private class AdminLoginListener implements Serializable, ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null,"This feature will be provided with in\nnext update");
		}
	}


/*
	ActionListener for the buttons that are contained within
	the student Login portal.  It will take care of the sign-in and sign-up
	like things. FileInputStream and ObjectInputStream are used within the method.
	Streams open the file and check for the credientails.FileOutputStream and
	ObjectOutputStream are used to make the binary files for sign-up.
*/

	private class StudentLoginListener implements ActionListener, Serializable{
		public void actionPerformed(ActionEvent event){
			if(event.getActionCommand().equals("Sign Up")){
			new StudentSignUp();
			}
			if(event.getActionCommand().equals("Sign In")){
				File file;
				FileInputStream fileInput;
				ObjectInputStream inputObject;
				try{
					file=new File("Database/Student/"+studentLogin.getText()+".dat");
					if(file.exists()){
						try{
							fileInput=new FileInputStream("Database/Student/"+studentLogin.getText()+".dat");
							inputObject=new ObjectInputStream(fileInput);
							LoginDatabase info=(LoginDatabase)inputObject.readObject();
							if(info.getPassword().equals(studentPassword.getText())){
								if(info.getAuthority().equals("Student")){
								String fileName=studentLogin.getText()+".dat";
								/*File questionFile=new File("Database/Question/Question.dat");
								if(questionFile.exists())
								new Student(fileName);
								else
								JOptionPane.showMessageDialog(null,"You are not allowed to login\nuntill the quiz is uploaded.");*/
									JOptionPane.showMessageDialog(null,"Password Status: Correct\nUser Status: Exists");
								}
								else{
									JOptionPane.showMessageDialog(null,"You are not Authorized to login from in here");
								}
								
							}
							else{
						JOptionPane.showMessageDialog(null,"Password status: INCORRECT\nUser Status: Exists");
					}
							
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null,"Error");
						}
					}
					else{
					JOptionPane.showMessageDialog(null,"User does not exist. Please SIgn Up");
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"ERROR");
				}
				
				
			}
		}
	}



/*
	ActionListener for the buttons that are contained within
	the Teacher Login portal.  It will take care of the sign-in and sign-up
	like things. FileInputStream and ObjectInputStream are used within the method.
	Streams open the file and check for the credientails. FileOutputStream and
	ObjectOutputStream are used to make the binary files for sign-up.
*/


	private class TeacherLoginListener implements ActionListener, Serializable{
		public void actionPerformed(ActionEvent event){
			if(event.getActionCommand().equals("Sign Up")){
			new TeacherSignUp();
			}
			else if(event.getActionCommand().equals("Sign In")){
				//File file;
				FileInputStream fileInput;
				ObjectInputStream inputObject;
				try{
					File file=new File("Database/Teacher/"+teacherLogin.getText()+".dat");
					if(file.exists()){
						try{
							fileInput=new FileInputStream("Database/Teacher/"+teacherLogin.getText()+".dat");
							inputObject=new ObjectInputStream(fileInput);
							LoginDatabase info=(LoginDatabase)inputObject.readObject();
							if(info.getPassword().equals(teacherPassword.getText())){
								if(info.getAuthority().equals("Teacher")){
								/*new TeacherChoice(info.getName());*/
								JOptionPane.showMessageDialog(null,"Password Status: Correct\nUser Status: Exists");
								}
								else{
									JOptionPane.showMessageDialog(null,"You are not authorized to Login from here.");
								}
								
							}
							else{
						JOptionPane.showMessageDialog(null,"Password status: INCORRECT\nUser Status: Exists");
						}
							
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null,"ERROR");
						}
					}
					else{
					JOptionPane.showMessageDialog(null,"User does not exist. Please SIgn Up");
					}
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"ERROR");
				}
				
				
			}
		}
	}

/*
	build the centerPAnel for content pane.

*/


	private void buildCenterPanel() {

		centerPanel=new JPanel();
		centerPanel.add(adminPanel);
		centerPanel.add(teacherLoginPanel);
		centerPanel.add(studentLoginPanel);
	}



/*
	build the NORTH PANEL for the content pane.
*/


	private void buildNorthPanel() {

		JLabel label=new JLabel("Quiz Oranizer");
		label.setFont(new Font("Monospaced",Font.BOLD,24));
		label.setForeground(Color.CYAN);
		northPanel=new JPanel();
		northPanel.setBackground(Color.BLUE);
		northPanel.add(label);
	}


/*
	build the SOUTH panel for content pane.
*/



	private void buildSouthPanel(){
		JLabel label=new JLabel("Hassan Saud Production pvt. ltd.");
		label.setFont(new Font("Monospaced",Font.BOLD,12));
		label.setForeground(Color.CYAN);
		southPanel=new JPanel();
		southPanel.setBackground(Color.BLUE);
		southPanel.add(label);
	}
	/*public static void main(String[] args){
		new Login1();
	}*/
}