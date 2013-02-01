package ch.warti.blackJack;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.warti.blackJack.strategy.SimpleStrategy;

public class GameTest {

	@Test
	public void testCreateCardStocks() {
		Game game = new Game();
		assertEquals(312, game.getAllCardsStock().size());		
		assertEquals(2, game.getAllCardsStock().get(1).getValue());
	}
	
	@Test
	public void testMixCards() {
		Game game = new Game();
		game.mixCards();
		assertEquals(312, game.getMixedCards().size());
	}
	
	@Test
	public void testPlayOneRound() {
		Game game = new Game();
		game.addDealer(new Dealer(1000000));
		game.addPlayer(new Player("Player1", new SimpleStrategy(16, 17), 1000));
		game.playRounds(1);
		game.printMoneyStatistics();
	}
	
	@Test
	public void testPlayOneRoundManyPlayers() {
		Game game = new Game();
		game.addDealer(new Dealer(1000000));
		game.addPlayer(new Player("Player1", new SimpleStrategy(16, 17), 1000));
		game.addPlayer(new Player("Player2", new SimpleStrategy(16, 17), 1000));
		game.addPlayer(new Player("Player3", new SimpleStrategy(16, 17), 1000));
		game.playRounds(1);
		game.printMoneyStatistics();
	}
	
	@Test
	public void testPlay1000RoundsManyPlayers() {
		Game game = new Game();
		game.addDealer(new Dealer(1000000));
		game.addPlayer(new Player("Player1", new SimpleStrategy(16, 17), 1000));
		game.addPlayer(new Player("Player2", new SimpleStrategy(16, 17), 1000));
		game.addPlayer(new Player("Player3", new SimpleStrategy(16, 17), 1000));
		game.playRounds(1000);
		game.printMoneyStatistics();
	}

}
