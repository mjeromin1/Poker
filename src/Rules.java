 /*
Mike Jeromin
Class Rules: defines the rules and checks of poker for 2kind, 2pair, 3kind, 
4kind, 5kind, straight, flush, and straight flush.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class Rules {

    protected List<Card> cards = new ArrayList<>();
    protected Map<String, Integer> cardAppearences = new TreeMap<>();
    protected Card cardOne, cardTwo, cardThree, cardFour, cardFive;
    protected int cardCount = 0;

    public void addCards() {
        if (cards.isEmpty()) {
            cards.add(cardOne);
            cards.add(cardTwo);
            cards.add(cardThree);
            cards.add(cardFour);
            cards.add(cardFive);
        }
    }

    public Card getHighCard() {
        //this will get the highest value card in the player's hand and return the
        //value of said card
        addCards();
        char value = 0, suitLetter = 0;
        int highCard = 0;
        for (Card card : cards) {
            if (card.getCardRankValue() >= highCard) {
                //if the card value is greater than or equal to the highest card
                //make this card the new highest card
                highCard = card.getCardRankValue();
            }
            if (card.getCardRankValue() == highCard) {
                //if the card value is equal to the highest card find the suit letter
                value = card.getNumberValue();
                suitLetter = card.getSuitLetter();
            }
        }
        Card highestCard = new Card(value, suitLetter);
        return highestCard;
    }

    public Card getNextHighestCard() {
        //this will get the next highest card in the hand and return it
        addCards();
        char value = 0, suitLetter = 0;
        int highCard = 0;
        int nextHighestCard = 0;
        for (Card card : cards) {
            if (card.getCardRankValue() >= highCard) {
                //if card value is greater than  or equal to current high card 
                //make this card the new highest card
                highCard = card.getCardRankValue();
            }
            if (card.getCardRankValue() >= nextHighestCard && card.getCardRankValue() != highCard) {
                //if the card value is greater than the nexthighestcard and that
                //card doesnt equal the highest card make this card the next highest
                nextHighestCard = card.getCardRankValue();
            }
            if (card.getCardRankValue() == nextHighestCard) {
                //if the card value is the same as the next highest card find 
                //this cards suit letter
                value = card.getNumberValue();
                suitLetter = card.getSuitLetter();
            }
        }
        Card highestCard = new Card(value, suitLetter);
        return highestCard;
    }
    
    public Card getNextHighestCard(int knownHighestCard) {
        //this will get the next highest card in the hand and return it
        addCards();
        char value = 0, suitLetter = 0;
        int highCard = 0;
        int nextHighestCard = 0;
        for (Card card : cards) {
            if (card.getCardRankValue() >= highCard) {
                //if card value is greater than  or equal to current high card 
                //make this card the new highest card
                highCard = card.getCardRankValue();
            }
            if (card.getCardRankValue() >= nextHighestCard && card.getCardRankValue() != highCard) {
                //if the card value is greater than the nexthighestcard and that
                //card doesnt equal the highest card make this card the next highest
                nextHighestCard = card.getCardRankValue();
            }
            if (card.getCardRankValue() == nextHighestCard) {
                //if the card value is the same as the next highest card find 
                //this cards suit letter
                value = card.getNumberValue();
                suitLetter = card.getSuitLetter();
            }
        }
        Card highestCard = new Card(value, suitLetter);
        return highestCard;
    }
    
    
    
   
    
    public void addToMapping() {
        //this will enter the cards into Map<String, Integer> 
        for (Card card : cards) {
            String cardNumber = Integer.toString(card.getCardRankValue());
            if (cardCount < 5) {
                if (cardAppearences.containsKey(cardNumber)) {
                    cardAppearences.put(cardNumber, cardAppearences.get(cardNumber) + 1);
                    cardCount++;
                } else {
                    cardAppearences.put(cardNumber, 1);
                    cardCount++;
                }
            }
        }
    }

    public boolean rule2Kind() {
        addCards();
        addToMapping();
        return cardAppearences.containsValue(2);//2 of a kind
    }

    public boolean rule2Pair() {
        addCards();
        int pairCount = 0;
        addToMapping();
        for (Map.Entry<String, Integer> pair : cardAppearences.entrySet()) {
            if (pair.getValue() == 2)//if equals 2 paris return the counter
                pairCount++;
        }
        return pairCount == 2;
    }

    public boolean rule3Kind() {
        addCards();
        addToMapping();
        return cardAppearences.containsValue(3);//3 of a kind
    }

    public boolean rule4Kind() {
        addCards();
        addToMapping();
        return cardAppearences.containsValue(4);//4 of a kind
    }

    public boolean ruleFullHouse() {
        addCards();
        addToMapping();
        return cardAppearences.containsValue(2) && cardAppearences.containsValue(3);
        //2 of kind and 3 of a kind
    }

    public boolean ruleFlush() {
        addCards();
        int heart = 0, diamond = 0, spade = 0, club = 0;
        for (Card card : cards) {
            if (card.getSuitLetter() == 'H') {heart++;}
            if (card.getSuitLetter() == 'D') {diamond++;}
            if (card.getSuitLetter() == 'S') {spade++;}
            if (card.getSuitLetter() == 'C') {club++;}
        }
        return heart == 5 || diamond == 5 || spade == 5 || club == 5;
    }

    public boolean ruleStraight() {
        int cardPartOfStraight = 0;
        addCards();
        cards.sort(Comparator.comparing(Card::getCardRankValue).reversed());
        if (cards.get(0).getCardRankValue() - cards.get(1).getCardRankValue() == 1) {cardPartOfStraight++;}//check first and second card
        if (cards.get(1).getCardRankValue() - cards.get(2).getCardRankValue() == 1) {cardPartOfStraight++;}//check second and third card
        if (cards.get(2).getCardRankValue() - cards.get(3).getCardRankValue() == 1) {cardPartOfStraight++;}//check third and fourth card
        if (cards.get(3).getCardRankValue() - cards.get(4).getCardRankValue() == 1) {cardPartOfStraight++;}//check fourth and fifth card
        return cardPartOfStraight == 4;//if 4 cardsInStraight return
    }

    public boolean ruleStraightFlush() {
        addCards();
        return ruleStraight() && ruleFlush();//checks both methods priorly written
    }

    public int tieValuePair() {
        int cardNumber = 0;
        for (Map.Entry<String, Integer> cardPosition : cardAppearences.entrySet()) {
            if (cardPosition.getValue() == 2) 
                cardNumber = Integer.parseInt(cardPosition.getKey());                
        }
        return cardNumber;
    }

    public int tieValue3Kind() {
        int cardNumber = 0;
        for (Map.Entry<String, Integer> cardPosition : cardAppearences.entrySet()) {
            if (cardPosition.getValue() == 3) 
                cardNumber = Integer.parseInt(cardPosition.getKey());
        }
        return cardNumber;
    }

    public int tieValue4Kind() {
        int cardNumber = 0;
        for (Map.Entry<String, Integer> cardPosition : cardAppearences.entrySet()) {
            if (cardPosition.getValue() == 4) 
                cardNumber = Integer.parseInt(cardPosition.getKey());
        }
        return cardNumber;
    }

    public int tieValue2Pair() {
        int cardNumber = 0;
        for (Map.Entry<String, Integer> cardPosition : cardAppearences.entrySet()) {
            if (cardPosition.getValue() == 2) {
                if (Integer.parseInt(cardPosition.getKey()) > cardNumber) {
                    cardNumber = Integer.parseInt(cardPosition.getKey());
                }
            } 
        }
        return cardNumber;
    }

}//end of Rules class
