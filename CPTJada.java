import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJada{
    public static void main(String [] args){
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
			con.println("p Play game");
			con.println("v View leaderboard");
			con.println("a  Add theme");
			con.println("h help");
			con.println("q Quit");
			con.println("select an option");
			strOption = con.readLine();
			
			if(strOption.equalsIgnoreCase("p")){
				TextInputFile themes = new TextInputFile("Themes.txt");
				String strTheme;
				String strWord;
				
				while(themes.eof()==false){
					strTheme = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();
					strWord = themes.readLine();

					con.println("theme is: "+strTheme);
			}	
					con.println("Enter theme");
					strTheme = con.readLine();
				
		}
				

			
		
	}
}
