package ch.warti.blackJack;

import ch.warti.blackJack.strategy.*;

public class Dealer extends Player {
	public Dealer(int startMoney) {
		super("Dealer", new SimpleStrategy(16, 17), startMoney);
	}

	public Card getFirstCard() {
		return hand.get(0);
	}

	public void wins(int bet) {
		this.bet = bet;
		this.wins();
	}

	public void loses(int bet) {
		this.bet = bet;
		this.loses();
	}
}
