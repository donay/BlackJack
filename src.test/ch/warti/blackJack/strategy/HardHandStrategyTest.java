package ch.warti.blackJack.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.warti.blackJack.Hand;
import ch.warti.blackJack.TestUtil;
import ch.warti.blackJack.strategy.hand.HardHandStrategyImpl;

public class HardHandStrategyTest {

	@Test
	public void testDealerAce_10_9_8_7drawTo16holdOn17() {
		//drawTo 16
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(10));
		hand.add(TestUtil.createCard(6));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(-1)));
		
		//holdOn 17
		hand = new Hand();
		hand.add(TestUtil.createCard(10));
		hand.add(TestUtil.createCard(7));
		assertEquals(false, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(-1)));
		assertEquals(false, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(10)));
		assertEquals(false, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(9)));
		assertEquals(false, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(8)));
		assertEquals(false, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(7)));
		
	}
	
	@Test
	public void testDealer6_5_4drawTo11() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(9));
		hand.add(TestUtil.createCard(2));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(6)));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(5)));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(4)));
	}
	
	@Test
	public void testDealer3_2drawTo12() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(10));
		hand.add(TestUtil.createCard(2));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(3)));
		assertEquals(true, new HardHandStrategyImpl().shouldHit(hand, TestUtil.createCard(2)));
	}
	
	@Test
	public void testNotDoubleLower8() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(6));
		hand.add(TestUtil.createCard(2));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(3)));
	}
	
	@Test
	public void testNotDoubleHigher12() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(6));
		hand.add(TestUtil.createCard(6));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(3)));
	}
	
	@Test
	public void testDoubleOn9NoAce2Cards_DealerCardIn6_5_4_3() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(3));
		hand.add(TestUtil.createCard(6));
		assertEquals(true, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(6)));
		assertEquals(true, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(5)));
		assertEquals(true, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(4)));
		assertEquals(true, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(3)));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(7)));
		
		hand.clear();
		hand.add(TestUtil.createCard(3));
		hand.add(TestUtil.createCard(3));
		hand.add(TestUtil.createCard(3));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(6)));
	}
	
	@Test
	public void testDoubleOn10_11NoAce2Cards_DealerCardNotInAce_10() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(4));
		hand.add(TestUtil.createCard(6));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(-1)));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(10)));
		assertEquals(true, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(4)));
		
		hand.clear();
		hand.add(TestUtil.createCard(4));
		hand.add(TestUtil.createCard(3));
		hand.add(TestUtil.createCard(3));
		assertEquals(false, new HardHandStrategyImpl().shouldDouble(hand, TestUtil.createCard(6)));
	}
}
