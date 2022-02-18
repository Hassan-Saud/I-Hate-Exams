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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Student extends JFrame implements Serializable{
	
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel westPanel;
	private JPanel eastPanel;
	private JRadioButton[] radioOption;
	private JTextArea[] optionArea;
	private JTextArea question;
	private JLabel[] testDetail1;
	private JLabel[] testDetail2;
	private JLabel[] candidateDetail1;
	private JLabel[] candidateDetail2;
	private JButton[] button;
	private String fileName;
	private ArrayList<Question> list;
	private FileInputStream file;
	private ObjectInputStream input;
	private int correctOption;
	private double result;
	private int count;
	private int submitCount;
	private int number;
	private int saveControl;
	private boolean status;
	private boolean nextStatus;
	private boolean[] checkArray;
	
/*
	Constructor to build the content pane.
	FileInputStream and ObjectInputStream are used
	to open the binary files to retrieve the information. 
*/

	public Student(String fileName)  {


		this.fileName=fileName;
		this.result=0.0;
		this.count=0;
		this.submitCount=0;
		this.number=0;
		this.saveControl=0;
		this.status=false;
		this.nextStatus=true;

		try{
			file=new FileInputStream(new File("Database/Question/Question.dat"));
			input=new ObjectInputStream(file);
			this.list=new ArrayList<>((Collection)input.readObject());
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Error");
		}
		
		setTitle("Student");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildWestPanel();
		buildCenterPanel();
		buildNorthPanel();
		buildSouthPanel();
		buildEastPanel();
		
		add(centerPanel,BorderLayout.CENTER);
		add(northPanel,BorderLayout.NORTH);
		add(southPanel,BorderLayout.SOUTH);
		add(eastPanel,BorderLayout.EAST);
		add(westPanel,BorderLayout.WEST);
		setSize(1368,768);
		setVisible(true);
	}


/*
	Method to build the center panel of the content pane.
*/

	private void buildCenterPanel() {

		centerPanel=new JPanel();
		Icon image1=new ImageIcon("Pictures/logo.png");
		JLabel label1=new JLabel(image1);
		Icon image2=new ImageIcon("Pictures/logo long.png");
		JLabel label2=new JLabel(image2);
		JPanel panel3=new JPanel();
		JPanel imagePanel=new JPanel();
		imagePanel.setLayout(new GridLayout(2,1));
		imagePanel.add(label1);
		imagePanel.add(label2);
		panel3.add(imagePanel);
		question=new JTextArea(3,30);
		question.setEditable(false);
		question.setFont(new Font("Dialog",Font.BOLD,15));
		question.setForeground(Color.BLACK);
		Question question1=list.get(0);
		question.setText(question1.getQuestion());
		radioOption=new JRadioButton[4];
		optionArea=new JTextArea[4];
		String[] option=question1.getOptions();
		correctOption=question1.getCorrectOption();
		ButtonGroup group=new ButtonGroup();
		for(int num=0;num<optionArea.length;num++){
			radioOption[num]=new JRadioButton("");
			group.add(radioOption[num]);
			optionArea[num]=new JTextArea(2,27);
			optionArea[num].setEditable(false);
			optionArea[num].setLineWrap(true);
			optionArea[num].setWrapStyleWord(true);
			optionArea[num].setText(option[num]);
		}
		JPanel optionPanel=new JPanel();
		for(int num=0;num<optionArea.length;num++){
			optionPanel.add(radioOption[num]);
			optionPanel.add(optionArea[num]);
		}
		JButton prevButton=new JButton("Previous");
		prevButton.setBackground(Color.BLUE);
		prevButton.setForeground(Color.WHITE);
		prevButton.addActionListener(new CenterButtonListener(radioOption));
		prevButton.setFont(new Font("Dialog",Font.PLAIN,13));
		JButton saveButton=new JButton("Save");
		saveButton.setBackground(Color.RED);
		saveButton.setForeground(Color.WHITE);
		saveButton.addActionListener(new CenterButtonListener(radioOption));
		saveButton.setFont(new Font("Dialog",Font.PLAIN,13));
		JButton nextButton=new JButton("Next");
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.addActionListener(new CenterButtonListener(radioOption));
		nextButton.setFont(new Font("Dialog",Font.PLAIN,13));
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(prevButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(nextButton);
		JPanel questionPanel=new JPanel();
		questionPanel.setLayout(new GridLayout(3,1));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Question"));
		questionPanel.add(question);
		questionPanel.add(optionPanel);
		questionPanel.add(buttonPanel);
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(panel3);
		centerPanel.add(questionPanel);
		
		
	}
	

/*
	ActionListener to Listen the events generated by the center panel buttons.
	Contains FileOutputStream, ObjectOutputStream, DataOutputStream and File
	classes to store the information in the binary files.
*/

	private class CenterButtonListener implements ActionListener, Serializable{
		private JRadioButton[] radio;
		private CenterButtonListener(JRadioButton[] radio){
			this.radio=radio;
		}
		public void actionPerformed(ActionEvent event){
			
			if(event.getActionCommand().equals("Save")){
				if(saveControl==0){
				if(radio[0].isSelected() || radio[1].isSelected() || radio[2].isSelected() || radio[3].isSelected()){
					
					
					for(int num=0;num<this.radio.length;num++){
						
						if(this.radio[num].isSelected()){
							number=num;
							if(num==correctOption){
								result+=(Double.parseDouble(testDetail2[0].getText()));
								
									if(nextStatus){
									status=true;
									}
								
							}
							
						}
					}
					saveControl+=1;
				
				}
				
				else{
					JOptionPane.showMessageDialog(null,"NO Option Selected");
				}
				}
				else{
					JOptionPane.showMessageDialog(null,"Already Saved.\nPlease move to the next Question.");
				}
			}
			else if(event.getActionCommand().equals("Next")){
				nextStatus=true;
				saveControl=0;
				count+=1;
				if(count>=list.size()){
					JOptionPane.showMessageDialog(null,"This is the Last Question.\nNo Questions after this.");
				}
				else{
				Question nextQuestion=list.get(count);
				question.setText(nextQuestion.getQuestion());
				String[] option=nextQuestion.getOptions();
				correctOption=nextQuestion.getCorrectOption();
				for(int num=0;num<this.radio.length;num++){
					optionArea[num].setText("");
					optionArea[num].setText(option[num]);
				}
				}
			}
			else if(event.getActionCommand().equals("Previous")){
				nextStatus=false;
				count-=1;
				if(status && nextStatus){
					result-=(Double.parseDouble(testDetail2[0].getText()));
				}
				saveControl=0;
				if(count<0){
					JOptionPane.showMessageDialog(null,"This is the First Question.\nNo Questions Before This.");
				}
				else{
				Question nextQuestion=list.get(count);
				question.setText(nextQuestion.getQuestion());
				String[] option=nextQuestion.getOptions();
				correctOption=nextQuestion.getCorrectOption();
				for(int num=0;num<this.radio.length;num++){
					optionArea[num].setText("");
					optionArea[num].setText(option[num]);
				}
				
				
			}	
			}
			else if(event.getActionCommand().equals("Submit")){
				submitCount+=1;
				if(submitCount==1){
				JOptionPane.showMessageDialog(null,"Your Result is: "+result);
				
				try{
					
				
					FileOutputStream file=new FileOutputStream("Database/Result Record/ResultRecord.dat",true);
					DataOutputStream output=new DataOutputStream(file);
					output.writeUTF("Name: "+candidateDetail2[0].getText());
					output.writeUTF("Roll No: "+candidateDetail2[1].getText());
					output.writeUTF("Department: "+candidateDetail2[2].getText());
					output.writeUTF("Session: "+candidateDetail2[3].getText());
					output.writeUTF("Email: "+candidateDetail2[4].getText());
					output.writeUTF("Marks Obtained: "+result);
					output.writeUTF("------------------------------------------");
					output.close();
				
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Error in Submitting");
				}
			
			}
			else{
				JOptionPane.showMessageDialog(null,"Alreday Submitted the Quiz.");
			}
			}
			
			
		}
	}

/*
	method to build the east panel of the content pane.
*/

	private void buildEastPanel(){
		eastPanel=new JPanel();
		button=new JButton[Integer.parseInt(testDetail2[1].getText())];
		for(int num=0;num<button.length;num++){
			button[num]=new JButton(""+(num+1));
			button[num].setBackground(Color.RED);
			button[num].setForeground(Color.WHITE);
			button[num].addActionListener(new ButtonArrayListener(radioOption));
		}
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(10,5,5,5));
		
		for(int num=0;num<button.length;num++){
			buttonPanel.add(button[num]);
		}
		JButton nextButton=new JButton("Next");
		JButton prevButton=new JButton("Previous");
		JButton submitButton=new JButton("Submit");
		submitButton.setBackground(Color.BLUE);
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Dialog",Font.PLAIN,13));
		submitButton.addActionListener(new CenterButtonListener(radioOption));
		JPanel submitPanel=new JPanel();
		submitPanel.add(submitButton);
		JPanel bigPanel=new JPanel();
		bigPanel.setLayout(new GridLayout(2,1));
		bigPanel.setBorder(BorderFactory.createTitledBorder("Question Navigation"));
		bigPanel.add(buttonPanel);
		bigPanel.add(submitPanel);
		eastPanel.add(bigPanel);
	
		
	}

/*
	ActionListener to response the events generated by the NAVIGATION-BUTTON
	array. Array is used to jump to the specific question. These buttons are visible
	in red color in the GUI.
*/
	private class ButtonArrayListener implements ActionListener, Serializable{
		private JRadioButton[] radio;
		private ButtonArrayListener(JRadioButton[] radio){
			this.radio=radio;
		}
		public void actionPerformed(ActionEvent event){
			
			count=Integer.parseInt(event.getActionCommand());
			count-=1;
			Question nextQuestion=list.get(count);
				question.setText(nextQuestion.getQuestion());
				String[] option=nextQuestion.getOptions();
				for(int num=0;num<this.radio.length;num++){
					optionArea[num].setText("");
					optionArea[num].setText(option[num]);
				}
				
		}
	}

/*
	method to build the WEST panel of the content pane.
	FileInputSTream and ObjectInputStream are used to get information
	from the files.
*/

	private void buildWestPanel(){
		
		westPanel=new JPanel();
		testDetail1=new JLabel[5];
		testDetail2=new JLabel[5];
		for(int num=0;num<testDetail1.length;num++){
			testDetail1[num]=new JLabel();
			testDetail2[num]=new JLabel();
			
		}
		testDetail1[0].setText("Marks Per Question: ");
		testDetail1[1].setText("Total Questions: ");
		testDetail1[2].setText("Total Marks: ");
		testDetail1[3].setText("Course Name: ");
		testDetail1[4].setText("Course Code: ");
		try{
		FileInputStream file=new FileInputStream("Database/Question/West.dat");
		ObjectInputStream input=new ObjectInputStream(file);
		String[] text=((WestPanelInformation)input.readObject()).getTexts();
		for(int num=0;num<testDetail2.length;num++){
			testDetail2[num].setText(text[num]);
		}
		input.close();
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"ERROR");
		}
		checkArray=new boolean[Integer.parseInt(testDetail2[1].getText())];
		JPanel panel1=new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder("Test Details"));
		panel1.setLayout(new GridLayout(5,5));
		
		for(int num=0;num<testDetail2.length;num++){
			panel1.add(testDetail1[num]);
			panel1.add(testDetail2[num]);
			
		}
		candidateDetail1=new JLabel[5];
		candidateDetail2=new JLabel[5];
		for(int num=0;num<candidateDetail1.length;num++){
			
			candidateDetail1[num]=new JLabel();
			candidateDetail2[num]=new JLabel();
		}
		candidateDetail1[0].setText("Name: ");
		candidateDetail1[1].setText("Roll No: ");
		candidateDetail1[2].setText("Department: ");
		candidateDetail1[3].setText("Session: ");
		candidateDetail1[4].setText("Email: ");
		try{
			FileInputStream file=new FileInputStream("Database/Student/"+fileName);
			ObjectInputStream input=new ObjectInputStream(file);
			LoginDatabase info=(LoginDatabase)input.readObject();
			candidateDetail2[0].setText(info.getName());
			candidateDetail2[1].setText(info.getRollNo());
			candidateDetail2[2].setText(info.getDepartment());
			candidateDetail2[3].setText(info.getSession());
			candidateDetail2[4].setText(info.getEmail());
			input.close();
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Error");
		}
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(5,5));
		panel2.setBorder(BorderFactory.createTitledBorder("Candidate Details"));
		for(int num=0;num<candidateDetail2.length;num++){
			
			panel2.add(candidateDetail1[num]);
			panel2.add(candidateDetail2[num]);
		}
		JTextArea commentBox=new JTextArea(10,20);
		commentBox.setEditable(false);
		commentBox.setLineWrap(true);
		commentBox.setWrapStyleWord(true);
		commentBox.setBackground(Color.ORANGE);
		commentBox.setForeground(Color.BLACK);
		commentBox.setFont(new Font("Dialog",Font.BOLD,13));
		JScrollPane scroll=new JScrollPane(commentBox);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		try{
			FileInputStream file=new FileInputStream("Database/Question/Comment.dat");
			ObjectInputStream input=new ObjectInputStream(file);
			EastComment comment=(EastComment)input.readObject();
			String text=comment.getComment();
			commentBox.setText(text);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Error");
		}
		JPanel commentPanel=new JPanel();
		commentPanel.setBorder(BorderFactory.createTitledBorder("NOTE"));
		commentPanel.add(scroll);
		westPanel.setLayout(new GridLayout(3,1));
		westPanel.add(panel1);
		westPanel.add(panel2);
		westPanel.add(commentPanel);
		
	}


/*
	method to build the north panel of the content pane.
*/

	private void buildNorthPanel(){
		northPanel=new JPanel();
		JLabel label=new JLabel("Quiz Organizer");
		label.setFont(new Font("Monospaced",Font.BOLD,24));
		label.setForeground(Color.CYAN);
		northPanel.setBackground(Color.BLUE);
		northPanel.add(label);
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
		new Student();
	}*/
}