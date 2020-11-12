package de.hfu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	/**
	 * In der main methode wird etwas von der tastatur eingelesen 
	 * und in grossbuchstaben ausgegeben
	 */
	
    public static void main( String[] args )
    {
    	//erstellen von scanner
        Scanner scanner = new Scanner(System.in);
        //text einlesen
        String text = scanner.next();
        //text ausgeben
        System.out.println(text.toUpperCase());
        //scanner schliessen
        scanner.close();
    }
}
