package ch.warti.blackJack;

import ch.warti.blackJack.strategy.Strategy;

public class Player {
	Hand hand;
	private String playerName;
	protected int bet;
	private int money;
	private Strategy strategy;
	
	private int playedRounds;
	private int mostMoneyEverHad;
	private int roundOfMostMoneyEverHad;
	
	public Player(String playerName, Strategy strategy, int startMoney) {
		this.playerName = playerName;
		this.strategy = strategy;
		this.money = startMoney;
		
		this.playedRounds = 0;
		this.mostMoneyEverHad = this.money;
		this.roundOfMostMoneyEverHad = this.playedRounds;
		this.bet = 1;
		this.hand = new Hand();
	}

	public void appendCard(Card card) {
		hand.add(card);		
	}
	
	public void newRound() {
		playedRounds++;
		
		if (mostMoneyEverHad<money) {
			mostMoneyEverHad = money;
			roundOfMostMoneyEverHad = playedRounds;
		}
		
		hand.clear();
	}
	
	public int wins() {
		money += bet;
		return bet;
	}
	
	public int loses() {
		money -= bet;
		return bet;
	}
	
	public boolean wantsHit(Card dealerCard) {
		return strategy.shouldHit(hand, dealerCard);
	}
	
	public int countCardPoints() {
		return strategy.countPoints(hand);
	}
	
	public boolean isBust() {
		return (strategy.countPoints(hand)>21);
	}
	
	
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getMoney() {
		return money;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public String getCardsAsString() {
		StringBuffer cardString = new StringBuffer();
		for (Card card : hand) {
			cardString.append(card.getValue());
			cardString.append(" ");
		}
		return cardString.toString();
	}
	
	public String getMostMoneyOnWhatRound(){
		return "Top on Round " + roundOfMostMoneyEverHad + " with " + mostMoneyEverHad;
	}
}
