/*	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com
*/

/*
	this class is same as the StudentSignUp. Except the two text Fields.
	some fields are made editable(false). all other things are same.
*/

package View;
import Controller.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TeacherSignUp extends JFrame implements Serializable{

	private JPanel centerPanel;
	private JPanel westPanel;
	private JPanel eastPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JButton submitButton;
	private JButton backButton;
	private JLabel[] label;
	private JTextField[] textField;
	private JPasswordField[] passwordField;

	public TeacherSignUp(){
		setTitle("Sign Up");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildWestPanel();
		buildEastPanel();
		buildNorthPanel();
		buildCenterPanel();
		buildSouthPanel();
		add(westPanel,BorderLayout.WEST);
		add(eastPanel,BorderLayout.EAST);
		add(northPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		setSize(1336,768);
		setVisible(true);
	}
	private void buildWestPanel(){
		westPanel=new JPanel();
		JPanel panel1=new JPanel();
		Icon image1=new ImageIcon("Pictures/gcu png logo.png");
		JLabel label1=new JLabel(image1);
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel1.add(label1);
		westPanel.add(panel1);
	}
	private void buildEastPanel(){
		eastPanel=new JPanel();
		JPanel panel=new JPanel();
		Icon image2=new ImageIcon("Pictures/logo.png");
		JLabel label2=new JLabel(image2);
		label2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(label2);
		eastPanel.add(panel);
	}
	private void buildNorthPanel(){
		northPanel=new JPanel();
		JLabel label=new JLabel("Quiz Organizer");
		label.setFont(new Font("Monospaced",Font.BOLD,24));
		label.setForeground(Color.CYAN);
		northPanel.setBackground(Color.BLUE);
		northPanel.add(label);
	}
	private void buildCenterPanel(){
		centerPanel=new JPanel();
		label=new JLabel[6];
		Icon image=new ImageIcon("Pictures/logo long.png");
		JLabel imageLabel=new JLabel(image);
		JPanel imagePanel=new JPanel();
		imagePanel.add(imageLabel);
		textField=new JTextField[6];
		JPanel panel=new JPanel();
		JCheckBox check=new JCheckBox("Agree to Terms and Conditions");
		check.setFont(new Font("Dialog",Font.BOLD,15));
		check.setForeground(Color.RED);
		panel.setLayout(new GridLayout(8,8));
		for(int num=0;num<label.length;num++){
			label[num]=new JLabel();
			textField[num]=new JTextField(20);
		}
		textField[2].setEditable(false);
		textField[3].setEditable(false);
		label[0].setText("Name");
		label[1].setText("Father's Name");
		label[2].setText("Roll no");
		label[3].setText("Session");
		label[4].setText("Department");
		label[5].setText("Email");
		for(int num=0;num<label.length;num++){
			panel.add(label[num]);
			panel.add(textField[num]);
		}
		JLabel[] passwordLabel=new JLabel[2];
		passwordField=new JPasswordField[2];
		passwordField[0]=new JPasswordField(20);
		passwordField[1]=new JPasswordField(20);
		passwordLabel[0]=new JLabel("Password");
		passwordLabel[1]=new JLabel("Confirm Password");
		for(int num=0;num<passwordLabel.length;num++){
			panel.add(passwordLabel[num]);
			panel.add(passwordField[num]);
		}
		submitButton=new JButton("Submit");
		submitButton.setBackground(Color.RED);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Dialog",Font.PLAIN,13));
		submitButton.addActionListener(new ButtonListener(check));
		backButton=new JButton("Back");
		backButton.setBackground(Color.BLUE);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Dialog",Font.PLAIN,13));
		backButton.addActionListener(new ButtonListener(check));
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(submitButton);
		buttonPanel.add(backButton);
		centerPanel.setLayout(new GridLayout(4,1));
		centerPanel.add(imagePanel);
		centerPanel.add(panel);
		centerPanel.add(check);
		centerPanel.add(buttonPanel);
	}
	private class ButtonListener implements ActionListener, Serializable{
		private JCheckBox check;
		private ButtonListener(JCheckBox check){
			this.check=check;
		}
		public void actionPerformed(ActionEvent event){
			if(event.getActionCommand().equals("Back")){
			new Login1();
			}
			if(event.getActionCommand().equals("Submit")){
				if(!check.isSelected()){
					JOptionPane.showMessageDialog(null,"Please fill in the check box");
				}
				else if(check.isSelected() && event.getActionCommand().equals("Submit")){
					String name, department, email, password, confirmPassword, authority;
					name=textField[0].getText();
					department=textField[4].getText();
					email=textField[5].getText();
					authority="Teacher";
					password=passwordField[0].getText();
					confirmPassword=passwordField[1].getText();
					if((name.equals("") || name==null) || (department.equals("") || department==null) || (email.equals("") || email==null) || (password.equals("") || password==null) || (confirmPassword.equals("") || confirmPassword==null)){
						JOptionPane.showMessageDialog(null,"Please fill in all the details");
					}	
					else if(!(password.equals(confirmPassword))){
						JOptionPane.showMessageDialog(null,"Passwords do not match.\nPlease make sure that Password and Confirm Password match.");
					}
					
					else{
					File file;
					FileOutputStream fileOutput;
					ObjectOutputStream objectOutput;
					try{
						file=new File("Database/Teacher/"+name+".dat");
						if(file.exists()){
							JOptionPane.showMessageDialog(null,"User Name Already Exists.");
						}
						else{
						fileOutput=new FileOutputStream("Database/Teacher/"+name+".dat");
						objectOutput=new ObjectOutputStream(fileOutput);
						objectOutput.writeObject(new LoginDatabase(name, password, email, null, department, null, authority));
						objectOutput.close();
						JOptionPane.showMessageDialog(null,"User Name:"+name+"\nPassword:"+password);
						}
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"ERROR");
					}
					}
						
				}
			}
		}
	}

	private void buildSouthPanel(){
		southPanel=new JPanel();
		JLabel label=new JLabel("Hassan Saud Production pvt. ltd.");
		label.setFont(new Font("Dialog",Font.BOLD,12));
		label.setForeground(Color.CYAN);
		southPanel.setBackground(Color.BLUE);
		southPanel.add(label);
	}
	/*public static void main(String[] args){
		new TeacherSignUp();
	}*/
}