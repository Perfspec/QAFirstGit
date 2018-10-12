package com.qa.InfiniteTerrain;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
	
	@Test
	public static void test() {
		Game player = new Game();
		
		assertTrue(player.distMonsterMin()>0.0);
		
		player.move('n');
	}

}
