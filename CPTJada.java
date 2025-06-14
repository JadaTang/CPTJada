//Jada
//May 25 2025
//June 12 2025
//CPT

import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;



public class CPTJada {
	public static void main(String[] args) {
		
		TextOutputFile fileScore = new TextOutputFile ("Leaderboard.txt",true);
		TextInputFile fileScore2 = new TextInputFile ("Leaderboard.txt");	
		TextOutputFile addTheme = new TextOutputFile ("AddTheme.txt");	
		
		System.out.println("Loaded data files");
	
		// Animations
		Console con = new Console("Guess the word!", 1280, 720);
		int intX = 500;
		int intY = 200;
		int intScore = 0;
		int intTotalScore = 0;
		String strPlayAgain = "yes";
		String strOption;
		String strName;
		String strAddTheme="a";
		int intWins=0;
		BufferedImage imgGuessTheWord = con.loadImage("GuessTheWord.png");
		while (intX > 0) {

			con.setDrawColor(new Color(70, 220, 230));
			//con.fillRoundRect(1000,intY,200,200,50,50);
			intY = intY + 1;

			con.drawImage(imgGuessTheWord,intX+500,100);
			intX = intX - 2;

			con.setDrawColor(new Color(200, 30, 30));

			con.repaint();
			con.sleep(3);
		}
		// Main menu
		con.println("Play game (p)");
		con.println("View leaderboard (v)");
		con.println("Add theme (a)");
		con.println("Help (h)");
		con.println("Quit (q)");
		con.println("Select an option");
		strOption = con.readLine();

	while(strOption.equalsIgnoreCase("q")==false){
		
		if (strOption.equalsIgnoreCase("p")) {
			con.println("Enter name");
			strName = con.readLine();
			while(strPlayAgain.equalsIgnoreCase("yes")){
				intScore = playGame(con);
				intTotalScore +=intScore;
				if(intScore>=0){
					intWins++;
				}	
				con.println("Total Score" +intTotalScore);
				con.println("Do you want to play again?");
				strPlayAgain = con.readLine();
				if(strPlayAgain.equalsIgnoreCase("no")){
					con.println("Player name:" +strName);
					con.println("Score:" +intScore);
					
					fileScore.println(strName);
					fileScore.println(intScore);	
					
					con.println("Play game (p)");
					con.println("View leaderboard (v)");
					con.println("Add theme (a)");
					con.println("Help (h)");
					con.println("Quit (q)");
					con.println("Select an option");
					strOption = con.readLine();
				}
			}
			con.println("Number of wins:" +intWins);

		}//if p 
		if (strOption.equalsIgnoreCase("v")) {
			int intCount3=0;
			int intA;
			String strScore[][];
			strScore = new String[99][2];
			while (fileScore2.eof() == false) {
				strScore[intCount3][0] = fileScore2.readLine();
				strScore[intCount3][1] = fileScore2.readLine();
				intCount3++;
			}

		//Testing the content in array
		//for(intA = 0; intA <= intCount3;intA++){
		// con.println("user is: "+strScore[intA][0]);
		// con.println("score is: "+strScore[intA][1]);
		//}//for 
		//con.println("intCount3" +intCount3);
		//con.println("intA" +intA);

			// bubble sort
			int intCount4;
			int intCount5;
			String strNameTemp;
			String strWordTemp;
			String strNumberTemp;

			for (intCount4 = 0; intCount4 < intCount3 - 1; intCount4++) {
				for (intCount5 = 0; intCount5 < intCount3 - 1; intCount5++) {
					// Convert the people's score to integer and compare
					if (Integer.parseInt(strScore[intCount5][1]) > Integer.parseInt(strScore[intCount5 + 1][1])) {
						// Swap here
						// swap name
						strNameTemp = strScore[intCount5][0];
						strScore[intCount5][0] = strScore[intCount5 + 1][0];
						strScore[intCount5 + 1][0] = strNameTemp;
						// swap numbers
						strNumberTemp = strScore[intCount5][1];
						strScore[intCount5][1] = strScore[intCount5 + 1][1];
						strScore[intCount5 + 1][1] = strNumberTemp;
					}
				}
			}
			// end bubble sort
		//Testing the content in array
		con.println("Player:          Score:");
		for(intA = 0; intA <= intCount3;intA++){
		 con.print(strScore[intA][0]);
		 con.println("                 "+strScore[intA][1]);
		}//for 
		
		con.println("Play game (p)");
		con.println("View leaderboard (v)");
		con.println("Add theme (a)");
		con.println("Help (h)");
		con.println("Quit (q)");
		con.println("Select an option");
		strOption = con.readLine();
		
		}//if v
		
		if(strOption.equalsIgnoreCase("a")){
				//con.println("Enter theme name");
				//strAddTheme = con.readLine();
				//addTheme.println(strAddTheme);
		while(strAddTheme.equalsIgnoreCase("stop")==false){
				con.println("Enter words in theme");
				strAddTheme = con.readLine();
				if(strAddTheme.equalsIgnoreCase("stop")==false){
				addTheme.println(strAddTheme);
				}
		}//while	
		con.println("Play game (p)");
		con.println("View leaderboard (v)");
		con.println("Add theme (a)");
		con.println("Help (h)");
		con.println("Quit (q)");
		con.println("Select an option");
		strOption = con.readLine();	
		}//if a
		
		addTheme.close();


		if(strOption.equalsIgnoreCase("h")){
			con.println("Help");
			con.println("");
			con.println("If enter p, the game of guess the word");
			con.println("will begin");
			con.println("");
			con.println("If enter v, show all player name and");
			con.println("scores");	
			con.println("");
			con.println("If enter a, add words to a new theme");
			con.println("enter words to the new theme,once");			
			con.println("enter stop, words will be outputted");
			con.println("to AddTheme.txt");	
			con.println("");
			con.println("If enter q, exit the game");	
			con.println("");
			con.println("End help");
			con.println("");
		con.println("Play game (p)");
		con.println("View leaderboard (v)");
		con.println("Add theme (a)");
		con.println("Help (h)");
		con.println("Quit (q)");
		con.println("Select an option");
		strOption = con.readLine();
		}//if h
		
	}//while
			con.println("End of game");
		


	fileScore.close();
	}

	public static int playGame(Console con) {
		String strTheme;
		int intScore = 0;
		String strWords[][];
		strWords = new String[10][2];
		con.println("Themes: Animals,Fruits,Colours");
		con.println("Enter theme");
		strTheme = con.readLine();
		TextInputFile theme;
		if (strTheme.equalsIgnoreCase("Animals")) {
		    theme = new TextInputFile("Animals.txt");
		}else if (strTheme.equalsIgnoreCase("Colours")) {
		    theme = new TextInputFile("Colours.txt");
		}else if (strTheme.equalsIgnoreCase("Fruits")) {
		    theme = new TextInputFile("Fruits.txt");
		}else{return 0;}
			int inti = 0;
			int intRandom;
			while (theme.eof() == false) {
				strWords[inti][0] = theme.readLine();
				intRandom = (int) (Math.random() * 100 + 1);
				strWords[inti][1] = intRandom + "";
				inti++;
			}

			int intCount;
			//for (intCount = 0; intCount < 10; intCount++) {
				//con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
			//}
			//String strWordsSorted[][];
			//strWordsSorted = new String[10][2];
			//strWordsSorted[][] = bubbleSort(strWords[][],10);

			// bubble sort
			int intCount2;
			String strNameTemp;
			String strWordTemp;
			String strNumberTemp;

			for (intCount2 = 0; intCount2 < 10 - 1; intCount2++) {
				for (intCount = 0; intCount < 10 - 1; intCount++) {
					// Convert the people's score to integer and compare
					if (Integer.parseInt(strWords[intCount][1]) > Integer.parseInt(strWords[intCount + 1][1])) {
						// Swap here
						// swap name
						strNameTemp = strWords[intCount][0];
						strWords[intCount][0] = strWords[intCount + 1][0];
						strWords[intCount + 1][0] = strNameTemp;
						// swap numbers
						strNumberTemp = strWords[intCount][1];
						strWords[intCount][1] = strWords[intCount + 1][1];
						strWords[intCount + 1][1] = strNumberTemp;
					}

				}
			}
			// end bubble sort

			//con.println("after sort");
			//for (intCount = 0; intCount < 10; intCount++) {
				//con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
			//}
		

		// Game of guessing the word

		// String strInput="apple";
		String strInput = strWords[0][0];
		String strD = "";
		String strLetter = "";
		int intLength;
		int i;
		int intEqual = 0;
		intLength = strInput.length();
		intScore = intLength;
		for (i = 1; i <= intLength; i++) {
			strD = strD + "_";
		}
		con.println(strD);

		// While...
		while (intScore >= 0 && strD.equalsIgnoreCase(strInput) == false) {
			intEqual = 0;
			con.println("Enter a letter");
			strLetter = con.readLine();
			// con.println("you entered " +strLetter);

			for (i = 0; i <= intLength - 1; i++) {
				// con.println(strInput.substring(i,i+1));
				if (strInput.substring(i, i + 1).equalsIgnoreCase(strLetter)) {
					// con.println("equals");
					strD = strD.substring(0, i) + strLetter + strD.substring(i + 1, intLength);
					intEqual = 1;
				} else {
					// intScore--;
					// con.println(intScore);
				}
			}
			if (intEqual == 0) {
				intScore--;
			}

			con.println(strD);
		}
		if (intScore <= 0) {
			con.println("wrong guess");
			con.println(intScore);
		} else {
			con.println("You win");
			con.println(intScore);
		}

		return intScore;

	}
	/*
	public static int bubbleSort(string strWords[][], int intSize) {	
		
			// bubble sort
			int intCount2;
			String strNameTemp;
			String strWordTemp;
			String strNumberTemp;

			for (intCount2 = 0; intCount2 < intSize - 1; intCount2++) {
				for (intCount = 0; intCount < intSize - 1; intCount++) {
					// Convert the people's score to integer and compare
					if (Integer.parseInt(strWords[intCount][1]) > Integer.parseInt(strWords[intCount + 1][1])) {
						// Swap here
						// swap name
						strNameTemp = strWords[intCount][0];
						strWords[intCount][0] = strWords[intCount + 1][0];
						strWords[intCount + 1][0] = strNameTemp;
						// swap numbers
						strNumberTemp = strWords[intCount][1];
						strWords[intCount][1] = strWords[intCount + 1][1];
						strWords[intCount + 1][1] = strNumberTemp;
					}

				}
			}
			// end bubble sort

			return strWords[][];
	
			
	}
	*/
}
