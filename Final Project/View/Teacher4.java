/*	Name: 		Hassan Saud
	Roll no:	0089-bscs-19
	Section:	B(Morning)
	Department: 	Computer Science (GCU Lahore).
	Semester: 	2
	email: 		hm862333@gmail.com
*/

package View;
import Controller.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Teacher4 extends JFrame implements Serializable{

	private JTextArea questionArea;
	private JRadioButton[] optionButtons;
	private JTextField[] optionFields;
	private JButton[] navigationButtons;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JPanel westPanel;
	private JPanel northPanel;
	private JPanel contactPanel;
	private JPanel centerSupportingPanel;
	private JPanel eastPanel;
	private JLabel label;
	private Icon image; 
	private Icon gcuLogo;
	private FileOutputStream file;
	private ObjectOutputStream outputObject;
	private ButtonGroup buttonGroup;
	private int recordNumber;
	private ArrayList<Question> questionList;
	private JTextField[] westPanelTextFields;
	private int uploadCount;
	private String userName;

/*
	constructor to build the content pane.
	FileOutputStream and ObjectOutputStream are used.
	layout is BorderLayout.
*/
	public Teacher4(String name){
		this.userName=name;
		recordNumber=0;
		this.uploadCount=0;
		try{
			file=new FileOutputStream("Database/Question/Question.dat");
			outputObject=new ObjectOutputStream(file);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"ERROR");
		}
		setTitle("Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildCenterPanel();
		buildSouthPanel();
		buildWestPanel();
		buildNorthPanel();
		buildEastPanel();
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		add(westPanel,BorderLayout.WEST);
		add(northPanel,BorderLayout.NORTH);
		add(eastPanel,BorderLayout.EAST);
		setSize(1336,768);
		setVisible(true);
	}

/*
	method to build the center panel of the content pane.
*/

	private void buildCenterPanel(){
		image=new ImageIcon("Pictures/logo.png");
		gcuLogo=new ImageIcon("Pictures/gcu png logo.png");
		JLabel logoLabel=new JLabel(image);
		JLabel gcuLabel=new JLabel(gcuLogo);
		JPanel imagePanel=new JPanel();
		centerPanel=new JPanel();
		centerSupportingPanel=new JPanel();
		JPanel questionAnswerPanel=new JPanel();
		questionAnswerPanel.setBorder(BorderFactory.createTitledBorder("Question"));
		buttonGroup=new ButtonGroup();
		optionButtons=new JRadioButton[4];
		navigationButtons=new JButton[3];
		optionFields=new JTextField[4];
		questionArea=new JTextArea(10,50);
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		centerPanel.setLayout(new GridLayout(3,1));
		for(int num=0;num<optionButtons.length;num++){
			optionButtons[num]=new JRadioButton("");
			optionFields[num]=new JTextField(13);
			buttonGroup.add(optionButtons[num]);
			
		}
		JPanel navPanel=buildNavigationPanel(navigationButtons, optionFields, questionArea, optionButtons);
		buildOptionPanel();
		imagePanel.setLayout(new GridLayout(1,2));
		imagePanel.add(gcuLabel);
		questionAnswerPanel.add(questionArea);
		questionAnswerPanel.add(centerSupportingPanel);	
		imagePanel.add(logoLabel);
		centerPanel.add(imagePanel);
		centerPanel.add(questionAnswerPanel);
		centerPanel.add(navPanel);
		
	}

/*
	method for the navigation buttons of the center panel.
*/

	private JPanel buildNavigationPanel(JButton[] buttons, JTextField[] optionField, JTextArea question, JRadioButton[] radio){
		JPanel panel=new JPanel();
		for(int num=0;num<buttons.length;num++){
			buttons[num]=new JButton();
		}
		buttons[0].setText("Previous");
		buttons[1].setText("Save");
		buttons[2].setText("Next");
		buttons[0].addActionListener(new NavigationButton(optionField, question, radio));
		buttons[1].addActionListener(new NavigationButton(optionField, question, radio));
		buttons[2].addActionListener(new NavigationButton(optionField, question, radio));
		for(int num=0;num<buttons.length;num++){
			if(num==1){
				buttons[num].setBackground(Color.RED);
				buttons[num].setForeground(Color.WHITE);
				buttons[num].setFont(new Font("Dialog",Font.BOLD,15));
			}
			else{
			buttons[num].setBackground(Color.BLUE);
			buttons[num].setForeground(Color.CYAN);
			}
			panel.add(buttons[num]);
		}
		return panel;
		
		
	}

/*
	ActionListener for the Navigation buttons of the center panel buttons.
*/

	private class NavigationButton implements ActionListener, Serializable{
		private JTextArea questionArea;
		private JTextField[] optionField;
		private String question;
		private String[] optionName;
		private JRadioButton[] radio;
		int correctOption;
		private NavigationButton(JTextField[] optionField, JTextArea questionArea, JRadioButton[] radio){
			this.questionArea=questionArea;
			this.optionField=optionField;
			this.radio=radio;
		}
		public void actionPerformed(ActionEvent event){
			optionName=new String[optionField.length];
			
			if(event.getActionCommand().equals("Save")){
				if(questionList.size()>Integer.parseInt(westPanelTextFields[1].getText())){
					JOptionPane.showMessageDialog(null,"You have reached the limit.\nNO More Questions.");
				}
				else{
				this.question=this.questionArea.getText();
				for(int num=0;num<this.radio.length;num++){
					if(this.radio[num].isSelected()){
						correctOption=num;
					}
				}
				for(int num=0;num<optionName.length;num++){
					this.optionName[num]=this.optionField[num].getText();
				}
				try{
				questionList.add(recordNumber,new Question(this.question, this.optionName, this.correctOption));
				
				
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"ERROR in inner Class");
				}
				}
			}
			if(event.getActionCommand().equals("Next")){
				if(questionList.size()>Integer.parseInt(westPanelTextFields[1].getText())){
					JOptionPane.showMessageDialog(null,"You have reached the limit.\nNO More Questions.");
				}
				else{
				recordNumber+=1;
				this.questionArea.setText("");
				for(int num=0;num<this.optionField.length;num++){
					this.optionField[num].setText("");
				}
			}
			}
			if(event.getActionCommand().equals("Previous")){
				recordNumber-=1;
				this.questionArea.setText(((Question)(questionList.get(recordNumber))).getQuestion());
				String[] radio=((Question)(questionList.get(recordNumber))).getOptions();
				int correctNumber=((Question)(questionList.get(recordNumber))).getCorrectOption();
				for(int num=0;num<this.optionField.length;num++){
					this.optionField[num].setText(radio[num]);
					if(num==correctNumber){
						this.radio[num].doClick();
					}
				}
				questionList.remove(recordNumber);
			}
		}
		
	}
	
/*
	method to build the radio buttons options and the options text fields.
*/

	private void buildOptionPanel(){
		centerSupportingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(int num=0;num<optionButtons.length;num++){
			centerSupportingPanel.add(optionButtons[num]);
			centerSupportingPanel.add(optionFields[num]);
		}
	}

/*
	builds the south panel.
*/
	private void buildSouthPanel(){
		southPanel=new JPanel();
		label=new JLabel("Hassan Saud Production pvt. ltd.");
		label.setBackground(Color.CYAN);
		label.setForeground(Color.CYAN);
		southPanel.setBackground(Color.BLUE);
		southPanel.add(label);
	}

/*
	builds the west panel.
*/
	private void buildWestPanel(){
		westPanel=new JPanel();
		westPanelTextFields=new JTextField[5];
		JLabel[] westPanelLabels=new JLabel[5];
		
		
		for(int num=0;num<westPanelTextFields.length;num++){
			westPanelTextFields[num]=new JTextField(10);
			westPanelLabels[num]=new JLabel();
			
		}
		westPanelTextFields[2].setEditable(false);
		String totalMarks=westPanelTextFields[0].getText();
		westPanelTextFields[2].setText(totalMarks);
		westPanelLabels[0].setText("Marks per Question: ");
		westPanelLabels[1].setText("Total Questions: ");
		westPanelLabels[2].setText("Total Marks: ");
		westPanelLabels[3].setText("Course Name: ");
		westPanelLabels[4].setText("Course Code: ");
		for(int num=0;num<westPanelLabels.length;num++){
			westPanelLabels[num].setForeground(Color.BLUE);
			westPanelLabels[num].setFont(new Font("Monospaced",Font.PLAIN,14));
		}
		
		westPanel.setLayout(new GridLayout(3,1));
		JPanel settingPanel=buildSmallPanel(westPanelLabels, westPanelTextFields);
		JPanel finalPanel=buildFinalQueryPanel();
		JPanel loginSettingPanel=buildLoginSettingPanel();
	
		westPanel.add(settingPanel);
		westPanel.add(finalPanel);
		westPanel.add(loginSettingPanel);
		//westPanel.add(contactPanel);
		
		
	}

/*
	method to build the small panels that support the major west panel
*/
	private JPanel buildLoginSettingPanel(){
		JPanel loginPanel=new JPanel();
		
		loginPanel.setBorder(BorderFactory.createTitledBorder("Account Settings"));
		JRadioButton accountDetailButton=new JRadioButton("Explore Account");
		accountDetailButton.setForeground(Color.BLUE);
		JRadioButton changePasswordButton=new JRadioButton("Change Password");
		changePasswordButton.setForeground(Color.BLUE);
		ButtonGroup group=new ButtonGroup();
		group.add(accountDetailButton);
		group.add(changePasswordButton);
		JButton go=new JButton("GO");
		go.setFont(new Font("Dialog",Font.BOLD,13));
		go.setBackground(Color.RED);
		go.setForeground(Color.WHITE);
		go.addActionListener(new GoListener(changePasswordButton, accountDetailButton));
		JRadioButton confirmButton=new JRadioButton("Use account settings for future use");
		loginPanel.setLayout(new GridLayout(4,1));
		JPanel panel1=new JPanel();
		panel1.add(accountDetailButton);
		JPanel panel2=new JPanel();
		panel2.add(changePasswordButton);
		JPanel panel3=new JPanel();
		panel3.add(go);
		loginPanel.add(accountDetailButton);
		loginPanel.add(changePasswordButton);
		loginPanel.add(panel3);
		loginPanel.add(confirmButton);
		return loginPanel;
	}


/*
	Actionlistener fo Go button in the last west panel.
*/
	private class GoListener implements ActionListener, Serializable{
		private JRadioButton radio1;
		private JRadioButton radio2;
		private GoListener(JRadioButton radio1, JRadioButton radio2){
			this.radio1=radio1;
			this.radio2=radio2;
		}
		public void actionPerformed(ActionEvent event){
			if(this.radio2.isSelected()){
				JOptionPane.showMessageDialog(null,"This feature will be provided in the next Update.");
			}
			if(this.radio1.isSelected()){
				new PasswordChange(userName);
			}
		}
	}


/*
	small panels that support the majjor west panel.
*/
	private JPanel buildSmallPanel(JLabel[] label, JTextField[] field){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(5,2));
		
		for(int num=0;num<(label.length)&&(num<field.length);num++){
			panel.add(label[num]);
			panel.add(field[num]);
		}
		JButton setButton=new JButton("Save Information");
		setButton.setFont(new Font("Dialog",Font.BOLD,15));
		setButton.setBackground(Color.RED);
		setButton.setForeground(Color.WHITE);
		setButton.addActionListener(new SaveInformation(field));
		JPanel newPanel=new JPanel();
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(setButton);
		newPanel.setLayout(new GridLayout(2,1));
		newPanel.setBorder(BorderFactory.createTitledBorder("Settings"));
		newPanel.add(panel);
		newPanel.add(buttonPanel);
		
		return newPanel;
	}

/*
action listener for the small west panels buttons.
*/
	private class SaveInformation implements ActionListener,Serializable{
		private JTextField[] textFields;
		private FileOutputStream file;
		private ObjectOutputStream objectOutput;
		private String[] texts;
		private SaveInformation(JTextField[] textFields){
			this.textFields=textFields;
			this.texts=new String[5];
		}
		public void actionPerformed(ActionEvent event){
			if((!((this.textFields[0].getText().equals("")) || (this.textFields[0].getText()==null)) && !((this.textFields[1].getText().equals("")) || (this.textFields[1].getText()==null)) && !((this.textFields[3].getText().equals("")) || (this.textFields[3].getText()==null)) && !((this.textFields[4].getText().equals("")) || (this.textFields[4].getText()==null)))){
			uploadCount=1;
			for(int num=0;num<texts.length;num++){
				if(num==2){
					this.textFields[num].setText(Double.parseDouble(this.textFields[0].getText())*Double.parseDouble(this.textFields[1].getText())+"");
				}
				this.texts[num]=this.textFields[num].getText();
				textFields[num].setEditable(false);
				
			}
			try{
				file=new FileOutputStream("Database/Question/West.dat");
				objectOutput=new ObjectOutputStream(file);
				objectOutput.writeObject(new WestPanelInformation(this.texts));
				objectOutput.close();
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Error.");
			}
			questionList=new ArrayList<Question>(Integer.parseInt(textFields[1].getText()));
		}
		else{
			JOptionPane.showMessageDialog(null,"All the fields must be properly filled in.");
		}
		}
	}

/*
	west supporting panel
*/
	private JPanel buildFinalQueryPanel(){
		JCheckBox finalSubmission=new JCheckBox("Proof Read Done.");
		finalSubmission.setForeground(Color.BLUE);
		JCheckBox submitQuery=new JCheckBox("Upload Paper");
		submitQuery.setForeground(Color.BLUE);
		JCheckBox termAgree=new JCheckBox("Agree to terms and conditions");
		termAgree.setForeground(Color.BLUE);
		JButton submitButton=new JButton("UPLOAD");
		submitButton.setFont(new Font("Dialog",Font.BOLD,15));
		submitButton.setBackground(Color.RED);
		submitButton.setForeground(Color.WHITE);
		submitButton.addActionListener(new FinalSubmission(finalSubmission, submitQuery, termAgree));
		JButton previewButton=new JButton("Preview");
		previewButton.setFont(new Font("Dialog",Font.BOLD,15));
		previewButton.setBackground(Color.BLACK);
		previewButton.setForeground(Color.WHITE);
		JPanel finalPanel=new JPanel();
		finalPanel.setBorder(BorderFactory.createTitledBorder("Final Submission"));
		finalPanel.setLayout(new GridLayout(4,1));
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(submitButton);
		finalPanel.add(finalSubmission);
		finalPanel.add(submitQuery);
		finalPanel.add(termAgree);
		finalPanel.add(buttonPanel);
		return finalPanel;
		
		
	}


/*
	west supporting action listener. Uses FileOutputStream and ObjectOutputStream.
*/
	private class FinalSubmission implements ActionListener, Serializable{
		private JCheckBox check1;
		private JCheckBox check2;
		private JCheckBox check3;
		private FinalSubmission(JCheckBox check1, JCheckBox check2, JCheckBox check3){
			this.check1=check1;
			this.check2=check2;
			this.check3=check3;
		}
		public void actionPerformed(ActionEvent event){
			String actionCommand=event.getActionCommand();
			if(actionCommand.equals("UPLOAD")){
				if(this.check1.isSelected() && this.check2.isSelected() && this.check3.isSelected() && uploadCount==1){
					try{
						File delete=new File("Database/Result Record/ResultRecord.dat");
						delete.delete();
						outputObject.writeObject(questionList);
						outputObject.close();
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error in Uploading");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select all the Check Boxes");
				}
			}
		}
	}
	

/*
	north panel of the content pane.
*/
	private void buildNorthPanel(){
		JLabel label=new JLabel("QUIZ ORGANIZER");
		northPanel=new JPanel();
		northPanel.setBackground(Color.BLUE);
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Monospaced",Font.BOLD,24));
		northPanel.add(label);
		
	}

/*
	east panel of the content pane.
*/

	private void buildEastPanel(){
		eastPanel=new JPanel();
		JTextArea helpNote=new JTextArea();
		helpNote.setEditable(false);
		helpNote.setWrapStyleWord(true);
		helpNote.setLineWrap(true);
		String helpText="Control Panel is the rigth side. All the necessary controls and settings are provided in the right side. Center is the Question field. Enter the question in the Big Text Area provided. Below are the options for the Question. Enter 4 possible answers for each question. Select the RIGHT ANSWER in the options. Click \"Next\" to move to the Next Question and \"Previous\" for the previous Question. Press \"Save\" to Save the question.";
		helpNote.setText(helpText);
		helpNote.setFont(new Font("Dialog",Font.ITALIC,13));
		helpNote.setBackground(Color.lightGray);
		helpNote.setForeground(Color.BLACK);
		JTextArea commentBox=new JTextArea(10,20);
		commentBox.setEditable(true);
		commentBox.setLineWrap(true);
		commentBox.setWrapStyleWord(true);
		commentBox.setFont(new Font("Dialog",Font.PLAIN,13));
		commentBox.setBackground(Color.lightGray);
		commentBox.setForeground(Color.BLACK);
		JScrollPane scroll=new JScrollPane(commentBox);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton saveButton=new JButton("Save");
		saveButton.setFont(new Font("Dialog",Font.BOLD,15));
		saveButton.setBackground(Color.RED);
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(new CommentButton(commentBox));
		JTextArea contactUs=new JTextArea();
		contactUs.setEditable(false);
		contactUs.setText("Designed and Built by Hassan Saud,\nRoll no: 0089-bscs-19\nSection: B(Morning)\nSession: 2019-2023\nDepartment of Computer Science, \nGCU Lahore\nMobile: 0300-0372287\nEmail: hm862333@gmail.com\nCentral Office:Okara");
		contactUs.setFont(new Font("Dialog",Font.BOLD,13));
		contactUs.setBackground(Color.ORANGE);
		contactUs.setForeground(Color.BLACK);
		JPanel helpPanel=new JPanel();
		JPanel commentPanel=new JPanel();
		JPanel contactPanel=new JPanel();
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(saveButton);
		commentPanel.setBorder(BorderFactory.createTitledBorder("SPECIAL NOTE"));
		contactPanel.setBorder(BorderFactory.createTitledBorder("CONTACT US"));
		commentPanel.setLayout(new GridLayout(3,1));
		helpPanel.add(helpNote);
		JLabel label=new JLabel("Enter Special Notes in here.");
		label.setForeground(Color.BLUE);
		commentPanel.add(label);
		commentPanel.add(scroll);
		commentPanel.add(buttonPanel);
		contactPanel.add(contactUs);
		eastPanel.setLayout(new GridLayout(3,1));
		eastPanel.add(helpNote);
		eastPanel.add(commentPanel);
		eastPanel.add(contactPanel);
		
	}

/*
	east comment box action listener. Uses FileOutputStream
	and ObjectOutputStream.
*/
	private class CommentButton implements ActionListener, Serializable{
		private JTextArea textArea;
		private FileOutputStream file;
		private ObjectOutputStream outputObject;
		private CommentButton(JTextArea textArea){
			this.textArea=textArea;
		}
		public void actionPerformed(ActionEvent event){
			String text=this.textArea.getText();
			try{
				file=new FileOutputStream("Database/Question/Comment.dat");
				outputObject=new ObjectOutputStream(file);
				outputObject.writeObject(new EastComment(text));
				//outputObject.close();
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"ERROR");
			}
			
		}
	}
	/*public static void main(String[] args){
		new Teacher4();
	}*/
}