package project2;

import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.apache.commons.lang3.time.StopWatch;

public class passwordLoginGUI {
	private String password = "";
	private String password2 = "";
	private String password3 = "";
	private Passwords info = new Passwords(password);
	private Passwords info2 = new Passwords(password2);
	private Passwords info3 = new Passwords(password3);
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private JTextField text3 = new JTextField();
	private final JButton buttPass2 = new JButton();
	private final JButton buttPass3 = new JButton();
	private final JButton butt2 = new JButton();
	private final JButton butt3 = new JButton();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel labelEmailBad = new JLabel();
	private JLabel labelEmailGood = new JLabel();
	private JLabel labelFaceBad = new JLabel();
	private JLabel labelFaceGood = new JLabel();
	private JLabel labelBankBad = new JLabel();
	private JLabel labelBankGood = new JLabel();
	private JLabel face = new JLabel();
	private JLabel bank = new JLabel();
	private JLabel labelIntro = new JLabel();
	public StopWatch stopWatch = new StopWatch();
	public int successfulLog;
	public float pass1Time;
	public float pass2Time;
	public float pass3Time;
	public JFrame passGenFrame;
	public JLabel user = new JLabel();
	public JTextField userName = new JTextField();
	public int unsuccessfulLogTimes = 0;
	//MAIN DIALOG WINDOW -adding things to the GUI
	public passwordLoginGUI(String pass, String pass2, String pass3){		
		passGenFrame = new JFrame();
		setPass1(pass);
		setPass2(pass2);
		setPass3(pass3);
		passGenFrame.setTitle("Password Dialog");
		passGenFrame.getContentPane().setLayout(null);
		passGenFrame.setBounds(100,100,480,430);
		passGenFrame.add(makeButton2());
		passGenFrame.add(userField());
		passGenFrame.add(makeButtonPass2());
		passGenFrame.add(makeButtonPass3());
		passGenFrame.add(butt3);
		passGenFrame.add(makeUserName());
		passGenFrame.add(makeText1());
		passGenFrame.add(makeText2());
		passGenFrame.add(makeText3());
		passGenFrame.add(makeLabelEmail());
		passGenFrame.add(makeLabelFace());
		passGenFrame.add(makeLabelBank());
		passGenFrame.add(makeLabelEmailGood());
		passGenFrame.add(makeLabelBankGood());
		passGenFrame.add(makeLabelFaceGood());
		passGenFrame.add(makeLabelEmailBad());
		passGenFrame.add(makeLabelBankBad());
		passGenFrame.add(makeLabelFaceBad());
		passGenFrame.add(makeLabelIntro());
		passGenFrame.add(makeButton3());
		//For a comboBox
		//this.add(makeCombo());
		passGenFrame.setVisible(true);
		passGenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	/*
	 * Action listeners for the text fields.
	 * Each time a text area is selected it starts a timer,
	 * if another text area is selected the timer stops, and resets itself.
	 * This is completed so that each text area isn't fighting for timer control.	
	 */
		
		butt2.requestFocus();
		text1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				stopWatch.reset();
				stopWatch.start();
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stopWatch.stop();
				return;
			}
		});
		
		
		text2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				stopWatch.reset();
				stopWatch.start();
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stopWatch.stop();
				return;
			}
		});
		
		text3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				stopWatch.reset();
				stopWatch.start();
				return;
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				stopWatch.stop();
				return;
			}
		});
		
		}
		
	
	
	//ALL THE CONTENTS OF THE GUI
	
/*
 * Each label that can be found within our designed GUI,
 * which is pretty much all the words that can be found on the interface.	
 */
	
	private JLabel makeLabelIntro(){
		labelIntro.setText("<html> This stage of the application will now test whether or not you can successfully login to each application using the password obtained from the previous session. <br> <br> To start please enter your password for the following applications.</html>");
		labelIntro.setBounds(40,5,400,80);
		return labelIntro;
	}
	
	
	private JLabel makeLabelEmail(){
		label1.setText("Enter Email Password");
		label1.setBounds(40,80,130,50);
		return label1;
	}
	
	private JLabel makeLabelFace(){
		face.setText("Enter Bank Password");
		face.setBounds(40, 152, 150, 50);
		return face;
	}
	
	private JLabel makeLabelBank(){
		bank.setText("Enter Facebook Password");
		bank.setBounds(40, 224, 130, 50);
		return bank;
	}
	
	private JLabel makeLabelEmailBad(){
		labelEmailBad.setText(" Password Incorrect");
		labelEmailBad.setBounds(40,150, 120, 20);
		labelEmailBad.setVisible(false);
		labelEmailBad.setOpaque(true);
		labelEmailBad.setBackground(Color.red);
		return labelEmailBad;
	}
	
	private JLabel makeLabelBankBad(){
		labelBankBad.setText(" Password Incorrect");
		labelBankBad.setBounds(40,220, 120, 20);
		labelBankBad.setVisible(false);
		labelBankBad.setOpaque(true);
		labelBankBad.setBackground(Color.red);
		return labelBankBad;
	}
	
	private JLabel makeLabelFaceBad(){
		labelFaceBad.setText(" Password Incorrect");
		labelFaceBad.setBounds(40,290, 120, 20);
		labelFaceBad.setVisible(false);
		labelFaceBad.setOpaque(true);
		labelFaceBad.setBackground(Color.red);
		return labelFaceBad;
	}
	
	
	private JLabel makeLabelEmailGood(){
		labelEmailGood.setText(" Password Correct");
		labelEmailGood.setBounds(40, 150, 120, 20);
		labelEmailGood.setVisible(false);
		labelEmailGood.setOpaque(true);
		labelEmailGood.setBackground(Color.green);
		return labelEmailGood;
	}
	
	private JLabel makeLabelBankGood(){
		labelBankGood.setText(" Password Correct");
		labelBankGood.setBounds(40, 220, 120, 20);
		labelBankGood.setVisible(false);
		labelBankGood.setOpaque(true);
		labelBankGood.setBackground(Color.green);
		return labelBankGood;
	}
	
	private JLabel makeLabelFaceGood(){
		labelFaceGood.setText(" Password Correct");
		labelFaceGood.setBounds(40, 290, 120, 20);
		labelFaceGood.setVisible(false);
		labelFaceGood.setOpaque(true);
		labelFaceGood.setBackground(Color.green);
		return labelFaceGood;
	}
	
	private JLabel makeUserName(){
		user.setText("Enter User Name");
		user.setBounds(40,305,100,30);
		user.setVisible(true);
		return user;
	}
	
	private JButton makeButton3(){
		butt3.setText("Log and close Session");
		butt3.setBounds(210, 330, 200, 30);
		butt3.setVisible(true);
		butt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
					try {
						List<String> lines = Arrays.asList(userName.getText() + "," + unsuccessfulLogTimes +"," + ((pass1Time + pass2Time + pass3Time)/3) + "," + successfulLog + "\n");
						Path file = Paths.get("Log.txt");
						Files.write(file, lines, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
						passGenFrame.dispatchEvent(new WindowEvent(passGenFrame,WindowEvent.WINDOW_CLOSING));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		return butt3;
	}
	
	
	/*
	 * Below are the button's used to "confirm" each password.
	 * When the button is pressed it will display the stopTime (From the apache.lang library)
	 * in minutes:seconds:milliseconds how long it took for the user to type in their password.
	 * Three buttons for three password confirmations.
	 * Inside each actionPerformed we can utilize the information recorded by both stopWatch,
	 * and any information calculated within the Passwords classFile.
	 */
	private JButton makeButton2(){
		
		butt2.setText("Confirm Password");
		butt2.setBounds(250, 120, 160, 30);
		butt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String pass = getPass1();
					
			//The password Confirmation
				//If nothing is in the text box
				if(text1.getText().equals("")){
					labelEmailBad.setVisible(false);
					labelEmailGood.setVisible(false);
				}
				
				//If the correct password is in the text box
				//Where the information from the password, and stopWatch is processed.
				else if(text1.getText().equals(pass)){
					labelEmailGood.setVisible(true);
					labelEmailBad.setVisible(false);
					successfulLog++;
					info.addLoginTime(Float.valueOf(stopWatch.toString().substring(6, 11)));
					pass1Time = Float.valueOf(stopWatch.toString().substring(6, 11));
					System.out.println(getPass1() + ": " + stopWatch.toString().substring(4, 11)+ "  Attempts: " + info.getUnSuccessfulLogTimes());
				}
				//If the incorrect password is in the text box
				else if(!text1.getText().equals(pass)){
					labelEmailBad.setVisible(true);
					info.addUnSuccessfulLogTimes();
					//If the password is incorrectly entered more than 3 times
					//the button to confirm will become inaccessible.
					if(info.getUnSuccessfulLogTimes() >= 3){
						butt2.setVisible(false);
					}
					//add unsuccessful login attempt.
					unsuccessfulLogTimes++;
					labelEmailGood.setVisible(false);
				}
				
			}
		});
		return butt2;
	}
	
private JButton makeButtonPass2(){
		
		buttPass2.setText("Confirm Password");
		buttPass2.setBounds(250, 190, 160, 30);
		buttPass2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1){
				
				String pass2 = getPass2();
			//The password Confirmation
				//If nothing is in the text box
				if(text2.getText().equals("")){
					labelBankGood.setVisible(false);
					labelBankBad.setVisible(false);
				}
				//If the correct password is in the text box
				else if(text2.getText().equals(pass2)){
					labelBankGood.setVisible(true);
					labelBankBad.setVisible(false);
					successfulLog++;
					info2.addLoginTime(Float.valueOf(stopWatch.toString().substring(6, 11)));
					pass2Time = Float.valueOf(stopWatch.toString().substring(6, 11));
					System.out.println(getPass2() + ": " + stopWatch.toString().substring(4, 11)+ "  Attempts: " + info2.getUnSuccessfulLogTimes());
				}
				//If the incorrect password is in the text box
				else if(!text2.getText().equals(pass2)){
					labelBankBad.setVisible(true);
					info2.addUnSuccessfulLogTimes();
					//If the password is incorrectly entered more than 3 times
					//the button to confirm will become inaccessible.
					if(info2.getUnSuccessfulLogTimes() >= 3){
						buttPass2.setVisible(false);
					}
					//add unsuccessful login attempt.
					unsuccessfulLogTimes++;
					labelBankGood.setVisible(false);
				}
				
			}
		});
		return buttPass2;
	}
	
private JButton makeButtonPass3(){
	
	buttPass3.setText("Confirm Password");
	buttPass3.setBounds(250, 262, 160, 30);
	buttPass3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e2){
			
			String pass3 = getPass3();
		//The password Confirmation
			//If nothing is in the text box
			if(text3.getText().equals("")){
				labelFaceGood.setVisible(false);
				labelFaceBad.setVisible(false);
			}
			//If the correct password is in the text box
			else if(text3.getText().equals(pass3)){
				labelFaceGood.setVisible(true);
				labelFaceBad.setVisible(false);
				successfulLog++;
				info3.addLoginTime(Float.valueOf(stopWatch.toString().substring(6, 11)));
				pass3Time = Float.valueOf(stopWatch.toString().substring(6, 11));
				System.out.println(getPass3() + ": " + stopWatch.toString().substring(4, 11) + "  Attempts: " + info3.getUnSuccessfulLogTimes());
			}
			//If the incorrect password is in the text box
			else if(!text3.getText().equals(pass3)){
				labelFaceBad.setVisible(true);
				info3.addUnSuccessfulLogTimes();
				//add unsuccessful login attempt.
				unsuccessfulLogTimes++;
				//If the password is incorrectly entered more than 3 times
				//the button to confirm will become inaccessible.
				if(info3.getUnSuccessfulLogTimes() >= 3){
					buttPass3.setVisible(false);
				}
				labelFaceGood.setVisible(false);
			}
		}
	});
	return buttPass3;
}
	
/*
 * The text fields for each of the passwords, their actionListeners are apart
 * of the constructed object at the top of the file.
 */
	
	private JTextField makeText1(){
		text1.setText("");
		text1.setFocusable(true);
		text1.setBounds(40, 120, 200, 30);
		return text1;
		
	}
	
	private JTextField makeText2(){
		text2.setText("");
		text2.setFocusable(true);
		text2.setBounds(40, 190, 200, 30);
		return text2;
	}
	
	private JTextField makeText3(){
		text3.setText("");
		text3.setFocusable(true);
		text3.setBounds(40, 262, 200, 30);
		return text3;
	}

	private JTextField userField(){
		userName.setText("");
		userName.setFocusable(true);
		userName.setBounds(40, 330, 100, 30);
		return userName;
	}
	
	//THE GETTER AND SETTER FOR THE PASSWORD
	
	public String getPass1(){
		return password;
	}
	
	public void setPass1(String p){
		password = p;
	}	
	
	public String getPass2(){
		return password2;
	}
	
	public void setPass2(String p){
		password2 = p;
	}	
	
	public String getPass3(){
		return password3;
	}
	
	public void setPass3(String p){
		password3 = p;
	}	
	
}
