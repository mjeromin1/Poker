/*
Mike Jeromin
Class card: will identify the number value and suitLetter of a card with according
getter methods.
*/
public class Card {

    private final char suitLetter;
    private final char numberValue;

    public Card(char numberValue, char suitLetter) {
        this.suitLetter = suitLetter;
        this.numberValue = numberValue;
    }

    public char getSuitLetter() {return suitLetter;}
    public char getNumberValue() {return numberValue;}

    public int getCardRankValue() {
        int value = 0;
        if (numberValue == '2'){value = 2;}
        if (numberValue == '3'){value = 3;}
        if (numberValue == '4'){value = 4;}
        if (numberValue == '5'){value = 5;}
        if (numberValue == '6'){value = 6;}
        if (numberValue == '7'){value = 7;}
        if (numberValue == '8'){value = 8;}
        if (numberValue == '9'){value = 9;}
        if (numberValue == 'T'){value = 10;}//ten
        if (numberValue == 'J'){value = 11;}//jack
        if (numberValue == 'Q'){value = 12;}//queen
        if (numberValue == 'K'){value = 13;}//king
        if (numberValue == 'A'){value = 14;}//ace
        return value;
    }
    
    public String getCardName(){
        String name = "";
        if (numberValue == '2'){name = "1";}
        if (numberValue == '3'){name = "2";};
        if (numberValue == '4'){name = "4";}
        if (numberValue == '5'){name = "5";}
        if (numberValue == '6'){name = "6";}
        if (numberValue == '7'){name = "7";}
        if (numberValue == '8'){name = "8";}
        if (numberValue == '9'){name = "9";}
        if(numberValue == 'T'){name = "10";}      
        if(numberValue == 'J'){name = "Jack";}
        if(numberValue == 'Q'){name = "Queen";}
        if(numberValue == 'K'){name = "King";}
        if(numberValue == 'A'){name = "Ace";}
        return name;
    }

    @Override
    public String toString() {
        String cardValue = Character.toString(numberValue);
        String cardSuit = Character.toString(suitLetter);
        return cardValue + cardSuit;
    }

}//end of Card class
