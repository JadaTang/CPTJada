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
		String strOption;
		BufferedImage imgFlower = con.loadImage("Flower.jpg");
		Font fntTest = con.loadFont("JouneyWhiskers-Regular.ttf",40);
		while(intX > 0){

			con.setDrawColor(new Color(70,220,230));
			con.fillRoundRect(1000,intY,20,30,5,10);
			intY = intY +1;
			
			
			con.drawImage(imgFlower,intX,650);
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
				TextInputFile themes = new TextInputFile("Animals.txt");
				String strWord;
				int intCount;
				int intI;
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
				
				String strWords[][];
				strWords = new String[10][2];
				int intRand;
				strWords[0][0] = "dogs";
				intRand = (int)(Math.random()*100+1);
				strWords[0][1] = intRand + "";
				
				
				
				}
			//}		
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
					
					//Game of guessing the word 
					//While...
					String strInput="apple";
					String strD="";
					String strLetter="";
					int intLength;
					int i;
					intLength = strInput.length();
					for(i = 1; i <= intLength;i++){
					strD = strD+"_";
					}
					con.println(strD);
					
					
					
					con.println("Enter a letter");
					strLetter = con.readLine();
					con.println("you entered " +strLetter);
					
					for(i = 0; i <= intLength-1;i++){
					//con.println(strInput.substring(i,i+1));
					if(strInput.substring(i,i+1).equalsIgnoreCase(strLetter)){
						//con.println("equals");
						strD=strD.substring(0,i)+strLetter+strD.substring(i+1,intLength);
					}		
				}			
					con.println(strD);
					
					//Leaderboard..
					
					//Add theme..
					
					//con.println("Enter theme");
					//strTheme = con.readLine();
					

					
					
				
		}				
	}

