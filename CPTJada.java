import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJada{
    public static void main(String [] args){
		
		//Animations
		Console con = new Console("Guess the word!", 1280,720);
		int intX = 500;
		int intY = 200;
		int intScore=0;
		String strOption;
		BufferedImage imgFlower = con.loadImage("Flower.jpg");
		Font fntTest = con.loadFont("JouneyWhiskers-Regular.ttf",40);
		while(intX > 0){

			con.setDrawColor(new Color(70,220,230));
			con.fillRoundRect(1000,intY,20,30,5,10);
			intY = intY +1;
			
			
			//con.drawImage(imgFlower,intX,650);
			intX = intX - 2;
			
			con.setDrawFont(fntTest);
			con.setDrawColor(new Color(200, 30, 30));


			con.repaint();
			con.sleep(3);
		}
		//Main menu
			con.println("Play game (p)");
			con.println("View leaderboard (v)");
			con.println("Add theme (a)");
			con.println("Help (h)");
			con.println("Quit (q)");
			con.println("Select an option");
			strOption = con.readLine();
			
			if(strOption.equalsIgnoreCase("p")){
				intScore = playGame(con);
				TextInputFile themes = new TextInputFile("Animals.txt");
				String strWord;
				//int intCount;
				//int intI;
				//strThemesWords = new String[11][3];
				
				//Load themes from Themes, load data into array
				//while(themes.eof()==false){
					//for(intCount = 0; intCount <= 2;intCount++){
					//strTheme = themes.readLine();
					//strThemesWords[0][intCount]=strTheme;
					//con.println("theme is: "+strTheme);
					
					//for(intI=1; intI <=10; intI++){
					//strWord = themes.readLine();
					//strThemesWords[intI][intCount]=strWord;
					//con.println("word is: "+strWord);
				/*
				String strWords[][];
				strWords = new String[10][2];
				int intRand;
				strWords[0][0] = "dogs";
				intRand = (int)(Math.random()*100+1);
				strWords[0][1] = intRand + "";
				strWords[1][0] = "cats";
				intRand = (int)(Math.random()*100+1);
				strWords[1][1] = intRand + ""; 
				strWords[2][0] = "bunny";
				intRand = (int)(Math.random()*100+1);
				strWords[2][1] = intRand + ""; 
				strWords[3][0] = "lion";
				intRand = (int)(Math.random()*100+1);
				strWords[3][1] = intRand + ""; 
				strWords[4][0] = "tiger";
				intRand = (int)(Math.random()*100+1);
				strWords[4][1] = intRand + ""; 
				strWords[5][0] = "elephant";
				intRand = (int)(Math.random()*100+1);
				strWords[5][1] = intRand + ""; 
				strWords[6][0] = "giraffe";
				intRand = (int)(Math.random()*100+1);
				strWords[6][1] = intRand + ""; 
				strWords[7][0] = "turtle";								
				intRand = (int)(Math.random()*100+1);
				strWords[7][1] = intRand + ""; 
				strWords[8][0] = "fish";	
				intRand = (int)(Math.random()*100+1);
				strWords[8][1] = intRand + ""; 
				strWords[9][0] = "fish";	
				intRand = (int)(Math.random()*100+1);
				strWords[9][1] = intRand + ""; 
				
				int intCount;
				for(intCount = 0; intCount < 10; intCount++){
					con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
				}
				*/
			}		
	    //}
					
					
					//Testing the content in array
					//for(intCount = 0; intCount <= 2;intCount++){
					//con.println("theme is: "+strThemesWords[0][intCount]);
					
					//for(intI=1; intI <=10; intI++){
					//con.println("word is: "+strThemesWords[intI][intCount]);
				//}
			//}
				
					//Find the randomized data 
					
					
					
					//Ask question
					//...
					
					
					//Leaderboard..
					
					//Add theme..
							
					
				
		}
		public static int playGame(Console con){
			String strName;
			String strTheme;
			int intScore=0;
			String strWords[][];
			strWords = new String[10][2];
			con.println("Enter name");
			strName = con.readLine();
			con.println("Themes: Animals,Fruits,Colours");
			con.println("Enter theme");
			strTheme = con.readLine();
			if(strTheme.equalsIgnoreCase("Animals")){
				TextInputFile theme = new TextInputFile("Animals.txt");
				int inti=0;
				int intRandom;
				while(theme.eof() == false){ 
					strWords[inti][0] = theme.readLine();
					intRandom = (int)(Math.random()*100+1);
					strWords[inti][1] = intRandom + ""; 
					inti++;
				}	
				
				int intCount;
				for(intCount = 0; intCount < 10; intCount++){
					con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
				}
				//bubble sort
				int intCount2;
				String strNameTemp;
				String strWordTemp;
				String strNumberTemp;
		
				for(intCount2 = 0; intCount2 < 10-1; intCount2++){
				for(intCount = 0; intCount < 10-1; intCount++){
				// Convert the people's score to integer and compare
				if(Integer.parseInt(strWords[intCount][1]) > Integer.parseInt(strWords[intCount+1][1])){
					// Swap here
					// swap name
					strNameTemp = strWords[intCount][0];
					strWords[intCount][0] = strWords[intCount+1][0];
					strWords[intCount+1][0] = strNameTemp;
					// swap numbers
					strNumberTemp = strWords[intCount][1];
					strWords[intCount][1] = strWords[intCount+1][1];
					strWords[intCount+1][1] = strNumberTemp;
				}

			}
		}
				//end bubble sort
				for(intCount = 0; intCount < 10; intCount++){
					con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
				}				
			}
			
					//Game of guessing the word 
					
					//String strInput="apple";
					String strInput = strWords[0][0];
					String strD="";
					String strLetter="";
					int intLength;
					int i;
					int intEqual=0;
					intLength = strInput.length();
					intScore=intLength;
					for(i = 1; i <= intLength;i++){
					strD = strD+"_";
					}
					con.println(strD);
					
					
					//While...
					while(intScore>=0 && strD.equalsIgnoreCase(strInput)== false){
						intEqual=0;
						con.println("Enter a letter");
						strLetter = con.readLine();
						//con.println("you entered " +strLetter);
					
						for(i = 0; i <= intLength-1;i++){
						//con.println(strInput.substring(i,i+1));
						if(strInput.substring(i,i+1).equalsIgnoreCase(strLetter)){
							//con.println("equals");
							strD=strD.substring(0,i)+strLetter+strD.substring(i+1,intLength);
							intEqual = 1;
						}
						else{
							//intScore--;
							//con.println(intScore);
						}
					}	
						if(intEqual==0){
							intScore--;
						}		
							
					con.println(strD);
				}
					if(intScore<=0){
						con.println("wrong guess");
						con.println(intScore);
				}
					else{
						con.println("Correct guess");
						con.println(intScore);
					}
					
		    return intScore;

	   }					
	}
