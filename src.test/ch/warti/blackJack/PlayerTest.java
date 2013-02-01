package ch.warti.blackJack;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.warti.blackJack.strategy.SimpleStrategy;


public class PlayerTest {

	@Test
	public void testCountsCardsNumbers() {
		Player pl = new Player("Pl1", new SimpleStrategy(16, 17), 1000);
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 7,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 5,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 6,0));		
		assertEquals(18, pl.countCardPoints());
	}
	
	@Test
	public void testCountsCardsWithAce() {
		Player pl = new Player("Pl1", new SimpleStrategy(16, 17), 1000);
		pl.appendCard(new Card(CardType.ACE, CardColour.HERZ, -1,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 5,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 6,0));		
		assertEquals(12, pl.countCardPoints());
	}
	
	@Test
	public void testCountsCardsWith2Aces() {
		Player pl = new Player("Pl1", new SimpleStrategy(16, 17), 1000);
		pl.appendCard(new Card(CardType.ACE, CardColour.HERZ, -1,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 5,0));
		pl.appendCard(new Card(CardType.NUMBER, CardColour.HERZ, 6,0));		
		pl.appendCard(new Card(CardType.ACE, CardColour.HERZ, -1,0));
		assertEquals(13, pl.countCardPoints());
	}

	@Test
	public void testCountsCardsWithAceBlackJack() {
		Player pl = new Player("Pl1", new SimpleStrategy(16, 17), 1000);
		pl.appendCard(new Card(CardType.ACE, CardColour.HERZ, -1,0));
		pl.appendCard(new Card(CardType.PIC, CardColour.HERZ, 10,0));
		assertEquals(21, pl.countCardPoints());
	}

}
