package ch.warti.blackJack;

public class TestUtil {
	public static Card createCard(int value) {
		if(value == -1) return new Card(CardType.ACE, CardColour.HERZ,value,0);
		return new Card(CardType.NUMBER, CardColour.HERZ,value,0);

	}
}
