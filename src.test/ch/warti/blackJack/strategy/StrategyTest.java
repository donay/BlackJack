package ch.warti.blackJack.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.CardColour;
import ch.warti.blackJack.CardType;
import ch.warti.blackJack.Hand;
import ch.warti.blackJack.strategy.StrategyUtil;

public class StrategyTest {

	@Test
	public void testUse1AceAsValue1() {
		ArrayList<Card> aces = new ArrayList<Card>();
		Card ace1 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace1);		
		
		assertEquals(1, StrategyUtil.useAceValueAs(20, ace1, aces));		
	}
	
	@Test
	public void testUse1AceAsValue11() {
		ArrayList<Card> aces = new ArrayList<Card>();
		Card ace1 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace1);		
		
		assertEquals(11, StrategyUtil.useAceValueAs(9, ace1, aces));		
	}
	
	@Test
	public void testUse2AceAsValue1() {
		ArrayList<Card> aces = new ArrayList<Card>();
		Card ace1 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace1);	
		Card ace2 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace2);	
		
		assertEquals(1, StrategyUtil.useAceValueAs(10, ace2, aces));		
	}
	
	@Test
	public void testUse2AceFirstAsValue11() {
		ArrayList<Card> aces = new ArrayList<Card>();
		Card ace1 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace1);	
		Card ace2 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace2);	
		
		assertEquals(11, StrategyUtil.useAceValueAs(9, ace1, aces));		
	}
	
	@Test
	public void testUse2AceSecondAsValue1() {
		ArrayList<Card> aces = new ArrayList<Card>();
		Card ace1 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace1);	
		Card ace2 = new Card(CardType.ACE, CardColour.HERZ, -1, 0);
		aces.add(ace2);	
		
		assertEquals(1, StrategyUtil.useAceValueAs(20, ace2, aces));		
	}
	
	@Test
	public void testSimpleShouldHitOn15() {
		Strategy str = new SimpleStrategy(16, 17);
		Hand hand = new Hand();
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,5,1));
		assertEquals(true, str.shouldHit(hand, null));		
	}
	
	@Test
	public void testSimpleShouldHitOn16() {
		Strategy str = new SimpleStrategy(16, 17);
		Hand hand = new Hand();
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,6,1));
		assertEquals(true, str.shouldHit(hand, null));		
	}
	
	@Test
	public void testSimpleShouldHitOn17() {
		Strategy str = new SimpleStrategy(16, 17);
		Hand hand = new Hand();
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,7,1));
		assertEquals(false, str.shouldHit(hand, null));		
	}

	
	@Test
	public void testIsHardHand10PlusAcePlus7() {
		Hand hand = new Hand();
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,10,1));
		hand.add(new Card(CardType.ACE, CardColour.HERZ,-1,1));
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,7,1));
		assertEquals(true, StrategyUtil.isHardHand(hand));	
	}
	
	@Test
	public void testIsNotHardHand4PlusAcePlus4() {
		Hand hand = new Hand();
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,4,1));
		hand.add(new Card(CardType.ACE, CardColour.HERZ,-1,1));
		hand.add(new Card(CardType.NUMBER, CardColour.HERZ,4,1));
		assertEquals(false, StrategyUtil.isHardHand(hand));	
	}
	
	
	@Test
	public void testShouldDouble() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testShouldSplit() {
		fail("Not yet implemented");
	}
}
