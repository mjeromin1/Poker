/*
Mike Jeromin
Class hand: this makes 5 cards in the players hands with according get methods.
*/ 
public class Hand extends Rules {

    public Hand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive) {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
        this.cardThree = cardThree;
        this.cardFour = cardFour;
        this.cardFive = cardFive;
    }

    public Card getCardOne() {return cardOne;}
    public Card getCardTwo() {return cardTwo;}
    public Card getCardThree() {return cardThree;}
    public Card getCardFour() {return cardFour;}
    public Card getCardFive() {return cardFive;}
    
    @Override
    public String toString() {
        return cardOne + " " + cardTwo + " " + cardThree + " " + cardFour + " " + cardFive;
    }

}//end of hand class
