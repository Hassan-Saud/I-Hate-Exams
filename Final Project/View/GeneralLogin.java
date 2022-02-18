package View;
import Controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class GeneralLogin extends JFrame implements Serializable{
	private JPanel loginPanel;
	private Icon image;
	private Icon logoImage;
	private JButton loginButton;
	private JTextField loginField;
	private JPasswordField passField;
	private JLabel loginLabel;
	private JLabel passLabel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JButton themeButton;
	private JLabel northLabel;
	private JLabel southLabel;
	
	
	public GeneralLogin(){
		
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1336,768);
		buildPanel();
		buildCenterPanel();
		buildNorthPanel();
		buildSouthPanel();
		setLayout(new BorderLayout());
		add(centerPanel,BorderLayout.CENTER);
		add(northPanel,BorderLayout.NORTH);
		add(southPanel,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	private void buildPanel(){
		this.themeButton=new JButton("Switch To DARK Mode");
		themeButton.setBackground(Color.BLUE);
		themeButton.setForeground(Color.WHITE);
		themeButton.setFont(new Font("Dialog",Font.BOLD,13));
		
		loginPanel=new JPanel();
		loginField=new JTextField(20);
		passField=new JPasswordField(20);
		passField.setForeground(Color.RED);
		loginLabel=new JLabel("User Name");
		passLabel=new JLabel("Password");
		loginButton=new JButton("Login");
		loginButton.setBackground(Color.RED);
		loginButton.setForeground(Color.WHITE);
		loginButton.addActionListener(new ButtonListener());
		loginButton.setFont(new Font("Dialog",Font.PLAIN+Font.BOLD,15));
		image=new ImageIcon("Pictures/logo.png");
		loginPanel.setLayout(new GridLayout(4,1));
		
		JLabel imageLabel=new JLabel(image);
		JLabel showLabel=new JLabel("<html>Department Of Computer Science<br><center>GCU Lahore</center></br></html>",SwingConstants.CENTER);
		showLabel.setFont(new Font("Dialog",Font.BOLD+Font.ITALIC,20));
		showLabel.setForeground(Color.BLUE);
		JPanel panel1=new JPanel();
		panel1.add(loginLabel);
		panel1.add(loginField);
		JPanel panel2=new JPanel();
		panel2.add(passLabel);
		panel2.add(passField);
		JPanel panel3=new JPanel();
		panel3.add(showLabel);
		JPanel panel4=new JPanel();
		panel4.setLayout(new GridLayout(2,1));
		
		JPanel lPanel=new JPanel();
		lPanel.add(loginButton);
		panel4.add(lPanel);
		JPanel themePanel=new JPanel();
		themePanel.add(themeButton);
		panel4.add(themePanel);
		JPanel panel5=new JPanel();
		panel5.setLayout(new GridLayout(2,1));
		panel5.add(panel1);
		panel5.add(panel2);
		loginPanel.add(imageLabel);
		loginPanel.add(panel3);
		loginPanel.add(panel5);
		loginPanel.add(panel4);
		themeButton.addActionListener(new ThemeListener(showLabel, panel1, panel2, panel3, panel4, panel5, lPanel, loginPanel,themePanel));
		
		
	}
	private class ButtonListener implements Serializable, ActionListener{
		public void actionPerformed(ActionEvent event){
			if((loginField.getText()==null || loginField.getText().equals("")) || (passField.getText()==null || passField.getText().equals(""))){
				JOptionPane.showMessageDialog(null,"Please Fill in the User Name and Password Properly.");
			}
			else {
			String text=loginField.getText();
			if(text.equals("admin") && passField.getText().equals("1234")){
				new Login1();
			}
			else if(new File("Database/Student/"+text+".dat").exists()){
				try{
					ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("Database/Student/"+text+".dat")));
					LoginDatabase info=(LoginDatabase)in.readObject();
					if(info.getAuthority().equals("Student")){
						if(passField.getText().equals(info.getPassword())){
							if(new File("Database/Question/Question.dat").exists()){
								String fileName=text+".dat";
								setVisible(false);
								new Student(fileName);
								}
							else
							JOptionPane.showMessageDialog(null,"You are not allowed to Login Until the\nQuiz is uploaded");
						}
						else if(!passField.getText().equals(info.getPassword())){
							JOptionPane.showMessageDialog(null,"Incorrect Password");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Not Authorised.");
					}
					in.close();
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
					
				}
				
			}
			else if(new File("Database/Teacher/"+text+".dat").exists()){
				try{
					ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("Database/Teacher/"+text+".dat")));
					LoginDatabase info=(LoginDatabase)in.readObject();
					if(info.getAuthority().equals("Teacher")){
						if(passField.getText().equals(info.getPassword())){
							setVisible(false);
							new TeacherChoice(text);
						}
						else{
							JOptionPane.showMessageDialog(null,"Incorrect Password.");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Not Authorised.");
					}
					in.close();
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
					
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null,"User Does Not Exist");
			}
			
		}
		
	}
	}
	
	
	private void buildNorthPanel() {

		northLabel=new JLabel("Quiz Oranizer");
		northLabel.setFont(new Font("Monospaced",Font.BOLD,24));
		northLabel.setForeground(Color.CYAN);
		northPanel=new JPanel();
		northPanel.setBackground(Color.BLUE);
		northPanel.add(northLabel);
	}
	
	private class ThemeListener implements ActionListener, Serializable{
		private JPanel panel1;
		private JPanel panel2;
		private JPanel panel3;
		private JPanel panel4;
		private JPanel panel5;
		private JPanel panel6;
		private JPanel panel7;
		private JPanel panel8;
		private JLabel label;
		private ThemeListener(JLabel label,JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5, JPanel panel6, JPanel panel7, JPanel panel8){
			this.panel1=panel1;
			this.panel2=panel2;
			this.panel3=panel3;
			this.panel4=panel4;
			this.panel5=panel5;
			this.panel6=panel6;
			this.panel7=panel7;
			this.panel8=panel8;
			this.label=label;
		}
		public void actionPerformed(ActionEvent event){
			if(event.getActionCommand().equals("Switch To DARK Mode")){
				panel1.setBackground(Color.darkGray);
				panel2.setBackground(Color.darkGray);
				panel3.setBackground(Color.darkGray);
				panel4.setBackground(Color.darkGray);
				panel5.setBackground(Color.darkGray);
				panel6.setBackground(Color.darkGray);
				panel7.setBackground(Color.darkGray);
				panel8.setBackground(Color.darkGray);
				label.setForeground(Color.CYAN);
				loginButton.setBackground(Color.CYAN);
				loginButton.setForeground(Color.darkGray);
				loginLabel.setForeground(Color.CYAN);
				passLabel.setForeground(Color.CYAN);
				themeButton.setActionCommand("Standard");
				themeButton.setText("Switch To Standard Mode");
				themeButton.setBackground(Color.CYAN);
				themeButton.setForeground(Color.darkGray);
				loginField.setBackground(Color.lightGray);
				loginField.setForeground(Color.BLACK);
				passField.setBackground(Color.lightGray);
				passField.setForeground(Color.BLACK);
				northPanel.setBackground(Color.BLACK);
				southPanel.setBackground(Color.BLACK);
			}
			if(event.getActionCommand().equals("Standard")){
				panel1.setBackground(Color.WHITE);
				panel2.setBackground(Color.WHITE);
				panel3.setBackground(Color.WHITE);
				panel4.setBackground(Color.WHITE);
				panel5.setBackground(Color.WHITE);
				panel6.setBackground(Color.WHITE);
				panel7.setBackground(Color.WHITE);
				panel8.setBackground(Color.WHITE);
				label.setForeground(Color.BLUE);
				loginButton.setBackground(Color.RED);
				loginButton.setForeground(Color.WHITE);
				loginLabel.setForeground(Color.BLACK);
				passLabel.setForeground(Color.BLACK);
				themeButton.setActionCommand("Switch To DARK Mode");
				themeButton.setText("Switch To DARK Mode");
				themeButton.setBackground(Color.BLUE);
				themeButton.setForeground(Color.WHITE);
				loginField.setBackground(Color.WHITE);
				loginField.setForeground(Color.BLUE);
				passField.setBackground(Color.WHITE);
				passField.setForeground(Color.RED);
				northPanel.setBackground(Color.BLUE);
				southPanel.setBackground(Color.BLUE);
			}
		}
	}


/*
	build the SOUTH panel for content pane.
*/



	private void buildSouthPanel(){
		southLabel=new JLabel("Hassan Saud Production pvt. ltd.");
		southLabel.setFont(new Font("Monospaced",Font.BOLD,12));
		southLabel.setForeground(Color.CYAN);
		southPanel=new JPanel();
		southPanel.setBackground(Color.BLUE);
		southPanel.add(southLabel);
	}
	private void buildCenterPanel(){
		centerPanel=new JPanel();
		Icon Image=new ImageIcon("Pictures/general.jpeg");
		JLabel label=new JLabel(Image);
		centerPanel.setLayout(new GridLayout(1,2));
		centerPanel.add(loginPanel);
		centerPanel.add(label);
		
	}
}