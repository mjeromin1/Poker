 /*
Mike Jeromin
Class Player: getter methods to check 2kind, 3kind, 4kind, 5kind, 2pair, flush, 
straight, and straight flush of the according player hands(white/black)
*/
import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected List<Hand> hands = new ArrayList<>();
    protected int count = 0;
    protected Card highCard = null;
    protected Card nextHighestCard = null;
    
    public int tiePairValue() {
        for (Rules hand : hands) {
            count = hand.tieValuePair();
        }
        return count;
    }

    public int tie2PairValue() {
        for (Rules hand : hands) {
            count = hand.tieValuePair();
        }
        return count;
    }

    public int tieThreeKindValue() {
        for (Rules hand : hands) {
            count = hand.tieValue3Kind();
        }
        return count;
    }

    public int tieFourKindValue() {
        for (Rules hand : hands) {
                count = hand.tieValue4Kind();
        }
        return count;
    }

    public boolean pair() {
        for (Rules hand : hands) {
            if (hand.rule2Kind()) {count++;}
        }
        return count == 1;
    }

    public boolean twoPair() {
        for (Rules hand : hands) {
            if (hand.rule2Pair()) {count++;}
        }
        return count == 1;
    }

    public boolean threeKind() {
        for (Rules hand : hands) {
            if (hand.rule3Kind()) {count++;}
        }
        return count == 1;
    }

    public boolean fourKind() {
        for (Rules hand : hands) {
            if (hand.rule4Kind()) {count++;}
        }
        return count == 1;
    }

    public boolean fullHouse() {
        for (Rules hand : hands) {
            if (hand.ruleFullHouse()) {count++;}
        }
        return count == 1;
    }

    public boolean flush() {
        for (Rules hand : hands) {
            if (hand.ruleFlush()) {count++;}
        }
        return count == 1;
    }

    public boolean straight() {
        for (Rules hand : hands) {
            if (hand.ruleStraight()) {count++;}
        }
        return count == 1;
    }

    public boolean straightFlush() {
        for (Rules hand : hands) {
            if (hand.ruleStraightFlush()) {count++;}
        }
        return count == 1;
    }

    public Card highCard() {
        for (Rules cards : hands) {
            highCard = cards.getHighCard();
        }
        return highCard;
    }

    public Card nextHighestCard() {
        for (Rules cards : hands) 
            nextHighestCard = cards.getNextHighestCard();        
        return nextHighestCard;
    }
    
//    public Card nextNextHighestCard(Card x) {
//        Card nextHighestCard = null;
//        Rules cards;
//        for (int i = 0; i < hands.size(); i++) {
//            nextHighestCard = cards.getNextHighestCard(x);
//        }
//        return nextHighestCard;
//    }

}//end of Player class
