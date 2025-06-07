import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJada {
	public static void main(String[] args) {
		
		TextOutputFile fileScore = new TextOutputFile ("Leaderboard.txt",true);
		
		// Animations
		Console con = new Console("Guess the word!", 1280, 720);
		int intX = 500;
		int intY = 200;
		int intScore = 0;
		int intTotalScore = 0;
		String strPlayAgain = "yes";
		String strOption;
		String strName;
		int intWins=0;
		BufferedImage imgFlower = con.loadImage("Flower.jpg");
		Font fntTest = con.loadFont("JouneyWhiskers-Regular.ttf", 40);
		while (intX > 0) {

			con.setDrawColor(new Color(70, 220, 230));
			con.fillRoundRect(1000, intY, 20, 30, 5, 10);
			intY = intY + 1;

			// con.drawImage(imgFlower,intX,650);
			intX = intX - 2;

			con.setDrawFont(fntTest);
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

		}//if
	}//while
			con.println("End of game");
		
			
		
		// }

		// Testing the content in array
		// for(intCount = 0; intCount <= 2;intCount++){
		// con.println("theme is: "+strThemesWords[0][intCount]);

		// for(intI=1; intI <=10; intI++){
		// con.println("word is: "+strThemesWords[intI][intCount]);
		// }
		// }

		// Leaderboard..

		// Add theme..

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
			for (intCount = 0; intCount < 10; intCount++) {
				con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
			}
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
			con.println("after sort");
			for (intCount = 0; intCount < 10; intCount++) {
				con.println(strWords[intCount][0] + "-" + strWords[intCount][1]);
			}
		

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
}
