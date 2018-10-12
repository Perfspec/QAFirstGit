package com.qa.InfiniteTerrain;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
	
	@Test
	public void test() {
		Game player = new Game();
		
		assertTrue(player.distMonsterMin() > 0.0);
	}

}
