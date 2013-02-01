package ch.warti.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Game {
	private List<Card> allCardsStock;

	private Stack<Card> mixedCards;
	private Dealer dealer;
	private List<Player> players;
	
	public Game () {
		players = new ArrayList<Player>();
		if (allCardsStock==null) createAllCards();
	}
	
	private void createAllCards() {
		allCardsStock = new ArrayList<Card>();	
		for (int stock=0; stock<6; stock++) {
			allCardsStock.addAll(createCardStock(stock));		
		}
	}

	private List<Card> createCardStock(int stockNumber) {
			List<Card> cardStock = new ArrayList<Card>();
			for (int c=0; c<4; c++) {
				CardColour cardColour = getCardColour(c);				
				cardStock.add(createAce(cardColour, stockNumber));
				cardStock.addAll(createNumberCards(cardColour, stockNumber));
				cardStock.addAll(createPicCards(cardColour, stockNumber));
			}
			return cardStock;
	}

	private List<Card> createPicCards(CardColour cardColour, int stockNumber) {
		List<Card> picCards = new ArrayList<Card>();
		for (int pic=0; pic < 3; pic++) {
			picCards.add(new Card(CardType.PIC, cardColour, 10, stockNumber));
		}
		return picCards;
	}

	private List<Card> createNumberCards(CardColour cardColour, int stockNumber) {
		List<Card> numberCards = new ArrayList<Card>();
		for (int number=2; number<=10; number++) {
			numberCards.add(new Card(CardType.NUMBER, cardColour, number, stockNumber));
		}
		return numberCards;
	}

	private Card createAce(CardColour cardColour, int stockNumber) {
		return new Card(CardType.ACE, cardColour, -1, stockNumber);
	}

	private CardColour getCardColour(int cardColour) {
		switch (cardColour) {
			case 0: return CardColour.KREUZ;
			case 1: return CardColour.PIK;
			case 2: return CardColour.HERZ;
			case 3: return CardColour.KARO;
		}
		return null;
	}

	private void playRound() {
		this.playersAndDealerNewRound();		
		this.mixCards();
		this.shareCards();
		
		playPlayersRound();
		playDealersRound();
		
		if (dealer.isBust()) {
			payNotBustedPlayers();
		} else {
			payWinningPlayers();
		}
	}

	private void payWinningPlayers() {
		for (Player player : this.players) {
			if (!player.isBust()) {
				if (player.countCardPoints()>dealer.countCardPoints()) {
					dealer.loses(player.wins());
				} else if (player.countCardPoints()<dealer.countCardPoints()) {
					dealer.wins(player.loses());
				}
			}
		}
	}

	private void payNotBustedPlayers() {
		for (Player player : this.players) {
			if (!player.isBust()) {
				dealer.loses(player.wins());
			}
		}
	}

	private void playDealersRound() {
		while (dealer.wantsHit(dealer.getFirstCard())) {
			dealer.appendCard(mixedCards.pop());
		}
	}

	private void playPlayersRound() {
		for (Player player : this.players) {
			while (player.wantsHit(dealer.getFirstCard())) {
				player.appendCard(mixedCards.pop());
			}
			if (player.isBust()) {
				dealer.wins(player.loses());
			}
		}
	}

	private void playersAndDealerNewRound() {
		for (Player player : players) {
			player.newRound();
		}
		dealer.newRound();
	}
	
	private void shareCards() {
		for (int cardsPerPlayer=0; cardsPerPlayer<2; cardsPerPlayer++) {
			appendCardToPlayers();
		}
		
		dealer.appendCard(mixedCards.pop());
	}

	private void appendCardToPlayers() {
		for (Player pl : players) {
			pl.appendCard(mixedCards.pop());
		}
	}

	public void mixCards() {
		mixedCards = new Stack<Card>();
		
		Random random = new Random();
		int randomRange = allCardsStock.size()-1;
		while (mixedCards.size()<allCardsStock.size()) {
			mixedCards.add(allCardsStock.get(random.nextInt(randomRange)));
		}
		
	}
	
	public List<Card> getAllCardsStock() {
		return allCardsStock;
	}
	
	public Stack<Card> getMixedCards() {
		return mixedCards;
	}

	public void addDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}

	public void playRounds(int maxRounds, boolean printCardStatistics) {
		
		for (int round=0; round<maxRounds; round++) {
			playRound();
			if (printCardStatistics) printCardStatistics();
		}
	}
	
	public void playRounds(int maxRounds) {
		playRounds(maxRounds, false);
	}
	
	public void printCardStatistics() {
		System.out.println(dealer.getPlayerName()+": " + dealer.getCardsAsString() + " = " + dealer.countCardPoints());
		for (Player player : players) {
			System.out.println(player.getPlayerName()+": " + player.getCardsAsString() + " = " + player.countCardPoints());
		}
	}
	
	public void printMoneyStatistics() {
		System.out.println(dealer.getPlayerName()+" with " + dealer.getStrategy().toString() + " " + dealer.getMostMoneyOnWhatRound() + ": " + dealer.getMoney());
		for (Player player : players) {
			System.out.println(player.getPlayerName()+" with " + player.getStrategy().toString() + " " + player.getMostMoneyOnWhatRound() + ": " + player.getMoney());
		}
	}
}
