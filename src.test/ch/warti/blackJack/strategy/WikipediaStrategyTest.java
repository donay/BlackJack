package ch.warti.blackJack.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.warti.blackJack.Hand;
import ch.warti.blackJack.TestUtil;
import ch.warti.blackJack.strategy.hand.SoftHandStrategyImpl;

public class WikipediaStrategyTest {

	@Test
	public void testSplitsOnDouble4Dealer5() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(4));
		hand.add(TestUtil.createCard(4));
		assertEquals(true, new WikipediaStrategy().shouldSplit(hand, TestUtil.createCard(5)));
	}

	@Test
	public void testNotSplitsOnDouble4Dealer7() {
		Hand hand = new Hand();
		hand.add(TestUtil.createCard(4));
		hand.add(TestUtil.createCard(4));
		assertEquals(false, new WikipediaStrategy().shouldSplit(hand, TestUtil.createCard(7)));
	}
}
