package com.qa.InfiniteTerrain;

import java.util.Scanner;

public class App 
{
	
   public static void main( String[] args )
    {
    	Scanner input = new Scanner(System.in);
    	Game player = new Game();
    	
    	while(!player.foundTreasure()) {
    		
    		player.move(input.next().charAt(0));
    		if(player.foundMonster()) {
    			player.flee();
    		}
    		
    	}
    	input.close();
    	System.out.println("OMG!!!");
    	System.out.println("You found the treasure, which is some magic slippers.");
    	System.out.println("Now click your heels together and repeat,");
    	System.out.println("There's no place like home.");
    	
    }	
}
