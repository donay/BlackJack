package ch.warti.blackJack;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealerTest {

	@Test
	public void testDrawsTo16() {
		Dealer dealer = new Dealer(1000);
		dealer.appendCard(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		dealer.appendCard(new Card(CardType.NUMBER, CardColour.HERZ,6,1));
		assertEquals(true, dealer.wantsHit(null));
	}
	
	@Test
	public void testHoldsOn17() {
		Dealer dealer = new Dealer(1000);
		dealer.appendCard(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		dealer.appendCard(new Card(CardType.NUMBER, CardColour.HERZ,7,1));
		assertEquals(false, dealer.wantsHit(null));
	}
	
	@Test
	public void testCountsFirstAceAs11() {
		Dealer dealer = new Dealer(1000);
		dealer.appendCard(new Card(CardType.ACE, CardColour.HERZ,-1,1));
		dealer.appendCard(new Card(CardType.NUMBER, CardColour.HERZ,7,1));
		assertEquals(false, dealer.wantsHit(null));
	}
	

}
