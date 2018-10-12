package com.qa.InfiniteTerrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {
	
	private TwoD treasure;
	private List<TwoD> monsters;
	
	Game(){
		treasure = new TwoD(100);
		monsters = new ArrayList<TwoD>(100);
		
		System.out.println("You are alone in a misty bog.");
		System.out.println("You can't see more than 5 feet in front of you.");
		System.out.println("There are wild noises in the mist.");
		System.out.println();
		System.out.println("Stay Alert!");
		
		System.out.println();
		System.out.println();
		System.out.println("There is a magic compass in your hand.");
		System.out.println("It tells you how far you are from treasure and safety.");
		System.out.printf("The current reading is %s.",treasure.dist());
		
		}
	
	public boolean foundTreasure() {
		return treasure.dist()<5.0;
	}
	
	public boolean foundMonster() {
		List<TwoD> copyMonster = new ArrayList<TwoD>();
		
		Predicate<TwoD> monsterFar = t -> (t.dist()>5.0);
		copyMonster.removeIf(monsterFar);
		
		return !copyMonster.isEmpty();
	}
	
	public void move(char a) {
		TwoD north = new TwoD(0.0,1.0);
		TwoD south = new TwoD(0.0,-1.0);
		TwoD east = new TwoD(1.0,0.0);
		TwoD west = new TwoD(-1.0,0.0);
		
		switch(a) {
		case 'n':
			treasure.update(north);
			monsters.stream().forEach(t -> t.update(north));
			break;
		case 's':
			treasure.update(south);
			monsters.stream().forEach(t -> t.update(south));
			break;
		case 'e':
			treasure.update(east);
			monsters.stream().forEach(t -> t.update(east));
			break;
		case 'w':
			treasure.update(west);
			monsters.stream().forEach(t -> t.update(west));
			break;
		default:
			System.out.println("Error: please enter n, s, e, w.");
				
		}
		System.out.printf("You are now %s feet from the treasure.",treasure.dist());
	}
	public void flee() {
		Random k = new Random();
		TwoD run = new TwoD(k.nextInt()%100);
		
		treasure.update(run);
		monsters.stream().forEach(t -> t.update(run));
		
		System.out.println("A monster is revealed from the bog!!");
		System.out.println();
		System.out.println();
		System.out.println("You had to flee!");
		System.out.printf("You are now %s feet from the treasure.",treasure.dist());
		
		
		
	
	}
	
	public double distMonsterMin() {
		return monsters.stream().sorted().collect(Collectors.toList()).get(0).dist();
	}
	

}
