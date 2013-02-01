package ch.warti.blackJack.statistics;

import ch.warti.blackJack.Dealer;
import ch.warti.blackJack.Game;
import ch.warti.blackJack.Player;
import ch.warti.blackJack.strategy.*;

public class GameStatistics {
	private static int million = 1000000;
	private static int thousand = 1000;
	
	public static void main(String[] args) {
		Game game;
		game = new Game();
		game.addDealer(new Dealer(thousand));
		game.addPlayer(new Player("Player1", new SimpleStrategy(20, 21), thousand));
		game.addPlayer(new Player("Player2", new SimpleStrategy(19, 21), thousand));
		game.addPlayer(new Player("Player3", new SimpleStrategy(18, 21), thousand));
		game.addPlayer(new Player("Player4", new SimpleStrategy(17, 21), thousand));
		game.addPlayer(new Player("Player5", new SimpleStrategy(16, 21), thousand));
		game.addPlayer(new Player("Player6", new SimpleStrategy(15, 21), thousand));
		game.addPlayer(new Player("Player7", new SimpleStrategy(14, 21), thousand));
		game.addPlayer(new Player("Player8", new SimpleStrategy(13, 21), thousand));
		game.addPlayer(new Player("Player9", new SimpleStrategy(12, 21), thousand));
		game.addPlayer(new Player("Player10", new SimpleStrategy(11, 21), thousand));
		game.playRounds(thousand);
		game.printMoneyStatistics();
		
		//WikiStrategy
		game = new Game();
		game.addDealer(new Dealer(thousand));
		game.addPlayer(new Player("Player1", new WikipediaStrategy(), thousand));
		game.addPlayer(new Player("Player2", new WikipediaStrategy(), thousand));
		game.addPlayer(new Player("Player3", new WikipediaStrategy(), thousand));
		game.addPlayer(new Player("Player4", new WikipediaStrategy(), thousand));
		game.playRounds(thousand);
		game.printMoneyStatistics();
		
		/*game = new Game();
		game.addDealer(new Dealer(thousand));
		game.addPlayer(new Player("Player1", new SimpleStrategyAceAs1(20, 21), thousand));
		game.addPlayer(new Player("Player2", new SimpleStrategyAceAs1(19, 21), thousand));
		game.addPlayer(new Player("Player3", new SimpleStrategyAceAs1(18, 21), thousand));
		game.addPlayer(new Player("Player4", new SimpleStrategyAceAs1(17, 21), thousand));
		game.addPlayer(new Player("Player5", new SimpleStrategyAceAs1(16, 21), thousand));
		game.addPlayer(new Player("Player6", new SimpleStrategyAceAs1(15, 21), thousand));
		game.addPlayer(new Player("Player7", new SimpleStrategyAceAs1(14, 21), thousand));
		game.addPlayer(new Player("Player8", new SimpleStrategyAceAs1(13, 21), thousand));
		game.addPlayer(new Player("Player9", new SimpleStrategyAceAs1(12, 21), thousand));
		game.addPlayer(new Player("Player10", new SimpleStrategyAceAs1(11, 21), thousand));
		game.playRounds(thousand);
		game.printMoneyStatistics();*/
		
		
	}

}
