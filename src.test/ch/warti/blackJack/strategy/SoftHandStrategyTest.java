package ch.warti.blackJack.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.warti.blackJack.Hand;
import ch.warti.blackJack.TestUtil;

public class SoftHandStrategyTest {

	@Test
	public void testNoHitOn19() {
		//drawTo 16
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(-1));
		hand.add(TestUtil.createCard(8));
		assertEquals(false, new SoftHandStrategy().shouldHit(hand, TestUtil.createCard(-1)));
	}
	
	@Test
	public void testDealerAce_10_9drawTo18_consistingOf3Cards() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(-1));
		hand.add(TestUtil.createCard(2));
		hand.add(TestUtil.createCard(5));
		assertEquals(true, new SoftHandStrategy().shouldHit(hand, TestUtil.createCard(-1)));
		assertEquals(false, new SoftHandStrategy().shouldHit(hand, TestUtil.createCard(5)));
	}
	
	@Test
	public void testHitOn17_consistingOf3Cards() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(-1));
		hand.add(TestUtil.createCard(2));
		hand.add(TestUtil.createCard(3));
		assertEquals(true, new SoftHandStrategy().shouldHit(hand, TestUtil.createCard(3)));
	}
	
}
