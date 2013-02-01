package ch.warti.blackJack;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -136760283719721488L;

	public Hand getAces() {
		Hand aces = new Hand();
		for (Card card : this) {
			if (card.getType() == CardType.ACE) aces.add(card);
		}
		return aces;
	}
	
	public Hand getWithoutAces() {
		Hand noAces = new Hand();
		noAces.addAll(this);
		noAces.removeAll(this.getAces());
		return noAces;
		
	}
	
	public boolean containsAces() {
		return (this.getAces().size() > 0);
	}
}
