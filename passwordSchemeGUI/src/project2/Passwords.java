package project2;
import java.util.*;


/*This class exists so that each password generated can hold information
 * throughout the testing phases. I realize it may have been easier to just
 * stick that information within the passwordLoginGUI but I like being able to
 * access as much as possible through 'object' like entities.
 * 
 */


public class Passwords {
	public String password;
	public List<Float> loginTimeArray;
	public float loginTime;
	public int successfulLogTimes;
	public int unsuccessfulLogTimes;
	
	
	public Passwords(String pass){
		this.password = pass;
		this.loginTimeArray = new ArrayList<Float>();
		successfulLogTimes = 0;
		unsuccessfulLogTimes = 0;
	}
	
	//PASSWORD STUFF///////////////////////////////////////////////////////////////////////////	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String pass){
		this.password = pass;
	}
	//END OF PASSWORD STUFF////////////////////////////////////////////////////////////////////
	
	
	//LOG ATTEMPT STUFF////////////////////////////////////////////////////////////////////////
	public int getSuccessfulLog(){
		return this.successfulLogTimes;
	}
	
	public void addSuccessfulLog(){
		this.successfulLogTimes = this.successfulLogTimes + 1;
	}
	
	public int getUnSuccessfulLogTimes(){
		return this.unsuccessfulLogTimes;
	}
	
	public void addUnSuccessfulLogTimes(){
		this.unsuccessfulLogTimes = this.unsuccessfulLogTimes + 1;
	}
	//END OF LOG ATTEMPT STUFF/////////////////////////////////////////////////////////////////
	
	
	//LOGIN TIME STUFF/////////////////////////////////////////////////////////////////////////
	public void getLoginTime(){
		for(int i=0;i<loginTimeArray.size();i++){
			System.out.print(loginTimeArray.get(i) + "\n");
		}
	}
	
	public float getAverageLoginTime(){
		float average = 0;
		float sum = 0;
		
		//Take each loginTime and add them into a sum.
		for(int i=0;i<loginTimeArray.size();i++){
			sum += loginTimeArray.get(i);
		}
		//Divide sum by number of loginTimes.
		average = sum / loginTimeArray.size();
		return average;
	}
	
	public void addLoginTime(float time){
		loginTimeArray.add(time);
	}
	
	// END OF LOGIN TIME STUFF/////////////////////////////////////////////////////////////////
}
