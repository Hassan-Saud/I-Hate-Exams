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
public class TeacherChoice extends JFrame implements Serializable{

	private JButton recordButton;
	private JButton quizButton;
	private JPanel westPanel;
	private JPanel centerPanel;
	private	JTextArea textArea;
	private String userName;

/*
	constructor to build the content pane.
	layout is BorderLayout.
*/
	public TeacherChoice(String name){
		this.userName=name;
		setTitle("Choice");
		setSize(1336,768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildPanel();
		add(westPanel,BorderLayout.WEST);
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}

/*
	panel contains all the details of the gui.
	added to the west.
*/
	private void buildPanel(){
		westPanel=new JPanel();
		textArea=new JTextArea(30,50);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		centerPanel=new JPanel();
		recordButton=new JButton("Result Record");
		recordButton.addActionListener(new ButtonListener());
		quizButton=new JButton("Compose Quiz");
		quizButton.addActionListener(new ButtonListener());
		JPanel panel1=new JPanel();
		panel1.add(recordButton);
		JPanel panel2=new JPanel();
		panel2.add(quizButton);
		westPanel.add(panel1);
		westPanel.add(panel2);
		centerPanel.add(scroll);
	}

/*
	action listener for the only two buttons.
	FileInputStream and ObjectInputStream and DataInputStream are used.
*/
	private class ButtonListener implements ActionListener, Serializable{
		public void actionPerformed(ActionEvent event){
			if(event.getActionCommand().equals("Result Record")){
				
				
				try{
					File fileName=new File("Database/Result Record/ResultRecord.dat");
					if(!fileName.exists()){
						JOptionPane.showMessageDialog(null,"No Record Yet.");
					}
					else{
					FileInputStream file=new FileInputStream("Database/Result Record/ResultRecord.dat");
					DataInputStream stream=new DataInputStream(file);
					//ObjectInputStream input=new ObjectInputStream(file);
					boolean eof=true;
					String record="";
					while(eof){
						try{
						record+=stream.readUTF();
						record+="\n";
						}
						catch(Exception ex){
							eof=false;
						}
					}
					textArea.setText(record);
				}
				}
			
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"ERROR");
				}
				
			}
			if(event.getActionCommand().equals("Compose Quiz")){
					setVisible(false);
					new Teacher4(userName);
				}
		}
	}
	/*public static void main(String[] args){
		new TeacherChoice();
	}*/
}