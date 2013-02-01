package ch.warti.blackJack;

public class Card {

	private CardType type;
	private CardColour coulour;
	private int value; // ACE = -1, because it depends on what context the Ace is used
	private int fromStock;

	public Card(CardType type, CardColour colour, int value, int fromStock) {
		this.type = type;
		this.coulour = colour;
		this.value = value;
		this.fromStock = fromStock;
	}
	
	public CardType getType() {
		return type;
	}
	
	public CardColour getCoulour() {
		return coulour;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getFromStock() {
		return fromStock;
	}
}
