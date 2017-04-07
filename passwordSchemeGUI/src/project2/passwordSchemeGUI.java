package project2;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/*
 * This class contains the main!
 * The class consists of mainly JFrame dialog options, which populate
 * the GUI aspect of the program.
 * Underneath the class is where I have written code for each element of the GUI.
 * isConfirmed() - Main way of telling the process that one JFrame is complete,
 * and that it should move on to create the next password.
 * After three passwordSchemeGUI's are completed a passwordLoginGUI object is called.
 * 
 */

public class passwordSchemeGUI{
	//The physical things used within the GUI
	private String subject;
	private String password = "";
	private boolean confirmed;
	private ArrayList<String> passwords = new ArrayList<String>();
	
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private final JButton butt1 = new JButton();
	private final JButton butt2 = new JButton();
	private final JButton butt3 = new JButton();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel labelIntro = new JLabel();
	
	//MAIN DIALOG WINDOW -adding things to the GUI
	public passwordSchemeGUI(String sub){
		subject = sub;
		confirmed = false;
		JFrame passGenFrame = new JFrame();
		passGenFrame.setTitle("Password Dialog");
		passGenFrame.getContentPane().setLayout(null);
		passGenFrame.setBounds(100,100,480,350);
		passGenFrame.add(makeButton());
		passGenFrame.add(makeButton2());
		passGenFrame.add(makeButton3(passGenFrame));
		passGenFrame.add(makeText1());
		passGenFrame.add(makeText2());
		passGenFrame.add(makeLabel());
		passGenFrame.add(makeLabel2());
		passGenFrame.add(makeLabel3());
		passGenFrame.add(makeLabel4());
		passGenFrame.add(makeLabelIntro());
		//For a comboBox
		//this.add(makeCombo());
		passGenFrame.setVisible(true);
		passGenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//ALL THE CONTENTS OF THE GUI
	
	
	private JLabel makeLabelIntro(){
		labelIntro.setText("<html> Welcome to Team 12's password generator. <br> <br> To start please press the \"Generate\" button to claim your assigned password. This password will be assigned for your " + subject + ".</html>");
		labelIntro.setBounds(40,5,400,80);
		return labelIntro;
	}
	

	private JLabel makeLabel(){
		label1.setText(subject + " Password");
		label1.setBounds(40,80,150,50);
		return label1;
	}
	
	private JLabel makeLabel2(){
		label2.setText("<html>1. Please remember your password. <br>2. Confirm your password in the textbox below. </html>");
		label2.setBounds(40,150,500,50);
		return label2;
	}
	
	private JLabel makeLabel3(){
		label3.setText(" Password Incorrect");
		label3.setBounds(40,240, 120, 20);
		label3.setVisible(false);
		label3.setOpaque(true);
		label3.setBackground(Color.red);
		return label3;
	}
	
	
	private JLabel makeLabel4(){
		label4.setText(" Password Correct");
		label4.setBounds(40, 240, 120, 20);
		label4.setVisible(false);
		label4.setOpaque(true);
		label4.setBackground(Color.green);
		return label4;
	}
	
	
	/*
	 * Button that Generates Password
	 */
	
	private JButton makeButton(){
		butt1.setText("Generate Passwords");
		butt1.setBounds(250, 120, 160, 30);
		butt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			//The password Generator
				String pass = "";
				//Word list that we use to generate passwords - 650 words long
				String[] wordList = {"account", "act", "addition", "adjustment", "advertisement", "agreement", "air", "amount", "amusement", "animal", "answer", "apparatus", "approval", "argument", "art", "attack", "attempt", "attention", "attraction", "authority", "back", "balance", "base", "behaviour", "belief", "birth", "bit", "bite", "blood", "blow", "body", "brass", "bread", "breath", "brother", "building", "burn", "burst", "business", "butter", "canvas", "care", "cause", "chalk", "chance", "change", "cloth", "coal", "colour", "comfort", "committee", "company", "comparison", "competition", "condition", "connection", "control", "cook", "copper", "copy", "cork", "cotton", "cough", "country", "cover", "crack", "credit", "crime", "crush", "cry", "current", "curve", "damage", "danger", "daughter", "day", "death", "debt", "decision", "degree", "design", "desire", "destruction", "detail", "development", "digestion", "direction", "discovery", "discussion", "disease", "disgust", "distance", "distribution", "division", "doubt", "drink", "driving", "dust", "earth", "edge", "education", "effect", "end", "error", "event", "example", "exchange", "existence", "expansion", "experience", "expert", "fact", "fall", "family", "father", "fear", "feeling", "fiction", "field", "fight", "fire", "flame", "flight", "flower", "fold", "food", "force", "form", "friend", "front", "fruit", "glass", "gold", "government", "grain", "grass", "grip", "group", "growth", "guide", "harbour", "harmony", "hate", "hearing", "heat", "help", "history", "hole", "hope", "hour", "humour", "ice", "idea", "impulse", "increase", "industry", "ink", "insect", "instrument", "insurance", "interest", "invention", "iron", "jelly", "join", "journey", "judge", "jump", "kick", "kiss", "knowledge", "land", "language", "laugh", "law", "lead", "learning", "leather", "letter", "level", "lift", "light", "limit", "linen", "liquid", "list", "look", "loss", "love", "machine", "man", "manager", "mark", "market", "mass", "meal", "measure", "meat", "meeting", "memory", "metal", "middle", "milk", "mind", "mine", "minute", "mist", "money", "month", "morning", "mother", "motion", "mountain", "move", "music", "name", "nation", "need", "news", "night", "noise", "note", "number", "observation", "offer", "oil", "operation", "opinion", "order", "organization", "ornament", "owner", "page", "pain", "paint", "paper", "part", "paste", "payment", "peace", "person", "place", "plant", "play", "pleasure", "point", "poison", "polish", "porter", "position", "powder", "power", "price", "print", "process", "produce", "profit", "property", "prose", "protest", "pull", "punishment", "purpose", "push", "quality", "question", "rain", "range", "rate", "ray", "reaction", "reading", "reason", "record", "regret", "relation", "religion", "representative", "request", "respect", "rest", "reward", "rhythm", "rice", "river", "road", "roll", "room", "rub", "rule", "run", "salt", "sand", "scale", "science", "sea", "seat", "secretary", "selection", "self", "sense", "servant", "sex", "shade", "shake", "shame", "shock", "side", "sign", "silk", "silver", "sister", "size", "sky", "sleep", "slip", "slope", "smash", "smell", "smile", "smoke", "sneeze", "snow", "soap", "society", "son", "song", "sort", "sound", "soup", "space", "stage", "start", "statement", "steam", "steel", "step", "stitch", "stone", "stop", "story", "stretch", "structure", "substance", "sugar", "suggestion", "summer", "support", "surprise", "swim", "system", "talk", "taste", "tax", "teaching", "tendency", "test", "theory", "thing", "thought", "thunder", "time", "tin", "top", "touch", "trade", "transport", "trick", "trouble", "turn", "twist", "unit", "use", "value", "verse", "vessel", "view", "voice", "walk", "war", "wash", "waste", "water", "wave", "wax", "way", "weather", "week", "weight", "wind", "wine", "winter", "woman", "wood", "wool", "word", "work", "wound", "writing", "year", "angle", "ant", "apple", "arch", "arm", "army", "baby", "bag", "ball", "band", "basin", "basket", "bath", "bed", "bee", "bell", "berry", "bird", "blade", "board", "boat", "bone", "book", "boot", "bottle", "box", "boy", "brain", "brake", "branch", "brick", "bridge", "brush", "bucket", "bulb", "button", "cake", "camera", "card", "cart", "carriage", "cat", "chain", "cheese", "chest", "chin", "church", "circle", "clock", "cloud", "coat", "collar", "comb", "cord", "cow", "cup", "curtain", "cushion", "dog", "door", "drain", "drawer", "dress", "drop", "ear", "egg", "engine", "eye", "face", "farm", "feather", "finger", "fish", "flag", "floor", "fly", "foot", "fork", "fowl", "frame", "garden", "girl", "glove", "goat", "gun", "hair", "hammer", "hand", "hat", "head", "heart", "hook", "horn", "horse", "hospital", "house", "island", "jewel", "kettle", "key", "knee", "knife", "knot", "leaf", "leg", "library", "line", "lip", "lock", "map", "match", "monkey", "moon", "mouth", "muscle", "nail", "neck", "needle", "nerve", "net", "nose", "nut", "office", "orange", "oven", "parcel", "pen", "pencil", "picture", "pig", "pin", "pipe", "plane", "plate", "plough", "pocket", "pot", "potato", "prison", "pump", "rail", "rat", "receipt", "ring", "rod", "roof", "root", "sail", "school", "scissors", "screw", "seed", "sheep", "shelf", "ship", "shirt", "shoe", "skin", "skirt", "snake", "sock", "spade", "sponge", "spoon", "spring", "square", "stamp", "star", "station", "stem", "stick", "stocking", "stomach", "store", "street", "sun", "table", "tail", "thread", "throat", "thumb", "ticket", "toe", "tongue", "tooth", "town", "train", "tray", "tree", "trousers", "umbrella", "wall", "watch", "wheel", "whip", "whistle", "window", "wing", "wire", "worm", "able", "acid", "angry", "automatic", "beautiful", "black", "boiling", "bright", "broken", "brown", "cheap", "chemical", "chief", "clean", "clear", "common", "complex", "conscious", "cut", "deep", "dependent", "early", "elastic", "electric", "equal", "fat", "fertile", "first", "fixed", "flat", "free", "frequent", "full", "general", "good", "great", "grey", "hanging", "happy", "hard", "healthy", "high", "hollow", "important", "kind", "like", "living", "long", "married", "material", "medical", "military", "natural", "necessary", "new", "normal", "open", "parallel", "past", "physical", "political", "poor", "possible", "present", "private", "probable", "quick", "quiet", "ready", "red", "regular", "responsible", "right", "round", "same", "second", "separate", "serious", "sharp", "smooth", "sticky", "stiff", "straight", "strong", "sudden", "sweet", "tall", "thick", "tight", "tired", "true", "violent", "waiting", "warm", "wet", "wide", "wise", "yellow", "young" };
				//For 3 words
				for(int i=0;i<3;i++){
					//Create a random number, from the size of our dictionary
					int ranNum = ThreadLocalRandom.current().nextInt(0,wordList.length - 1);
					//Concatenate the string to create a single password of the three words.
					pass = pass.concat(wordList[ranNum] + " ");
				}
				//Trim the last password so that there exists no space at the end.
				    pass = pass.trim();
					text1.setText(pass);
					setPass(pass);
			}
		});
		return butt1;
	}
	
	/*
	 * The Confirm button
	 */
	private JButton makeButton2(){
		
		butt2.setText("Confirm Password");
		butt2.setBounds(250, 200, 160, 30);
		butt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String pass = getPass();
			//The password Confirmation
				//If nothing is in the text box
				if(text2.getText().equals("")){
					label3.setVisible(false);
					label4.setVisible(false);
				}
				//If the correct password is in the text box
				else if(text2.getText().equals(pass)){
					label4.setVisible(true);
					label3.setVisible(false);
				}
				//If the incorrect password is in the text box
				else if(!text2.getText().equals(pass)){
					label3.setVisible(true);
					label4.setVisible(false);
					butt3.setVisible(false);
				}
				
				if(label4.isVisible() == true){
					butt3.setVisible(true);
				}
				
			}
		});
		return butt2;
	}
	
	/*
	 * The Continue to Next Password button.
	 * Pretty much just reruns the password generator with a few changes
	 */
	
	private JButton makeButton3(JFrame frame){
		butt3.setText("Continue to next password =>");
		butt3.setBounds(40, 270, 370, 30);
		butt3.setVisible(false);
		butt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String pass = getPass();
				passwords.add(pass);
				setConfirmed(true);
				frame.setVisible(false);
			}
		});
		return butt3;
	}
	
	private JTextField makeText1(){
		text1.setText("");
		text1.setBounds(40, 120, 200, 30);
		return text1;
	}
	
	private JTextField makeText2(){
		text2.setText("");
		text2.setBounds(40, 200, 200, 30);
		return text2;
	}

	//THE GETTER AND SETTER FOR THE PASSWORD
	
	public String getPass(){
		return password;
	}
	
	public void setPass(String p){
		password = p;
	}	
	
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public static void main(String[] args){
	
		boolean next = false;
		passwordSchemeGUI app = new passwordSchemeGUI("EMAIL");
		
	   /*The below is a wait time method used to slow the while check.
	    * If this is removed the while will check to quickly to load
	    * the remaining two calls for the passwordSchemeGUI and only permit
	    * the entry of the first email password, and fail to call the passwordLoginGUI
	    * which will ultimately not collect the data needed for the project.
	    */
		while(next == false){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(app.isConfirmed() == true){
				next = true;
			}
		}
		
		passwordSchemeGUI app2 = new passwordSchemeGUI("BANK");
		next = false;
		while(next == false){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(app2.isConfirmed() == true){
				next = true;
			}
		}
		passwordSchemeGUI app3 = new passwordSchemeGUI("FACEBOOK");
		next = false;
		while(app3.isConfirmed() == false){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(app3.isConfirmed() == true){
				next = true;
			}
		}
		//The below allows for the passwords to be printed for testing purposes.
		//System.out.println(app.getPass() + " / " + app2.getPass() + " / " + app3.getPass());
		
		/*Part of the passwordLoginGUI class, creates a separate GUI which is used to
		 * deal with each password passed into it's arguments. Created to support the 
		 * three necessary requirement passwords defined within the project outline.
		*/
		passwordLoginGUI login = new passwordLoginGUI(app.getPass(),app2.getPass(),app3.getPass());
		
		
	}
	

	
}

