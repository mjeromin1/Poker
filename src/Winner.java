 /*
Mike Jeromin
Class Winner: decides the victor and prints out the winning hand to the console.


Values of Winning Poker

2: 2
3: 3
4: 4
5: 5
6: 6
7: 7
8: 8
9: 9
T: 10
J: 11
Q: 12
K: 13
A: 14
Pair: 15
2 Pair: 16
3 Kind: 17
Straight: 18
Flush: 19
Full House: 20
4 Kind: 21
Straight Flush: 22

*/
public class Winner {
    protected static int valueBlack = 0, valueWhite = 0;
    protected static String winnerBlack = "", winnerWhite = "";

    public static void whoWins(Black black, White white) {
        winnerBlack(black);
        winnerWhite(white);
        winner(black, white);
    }

    public static void winner(Black black, White white) {
        if (valueBlack > valueWhite) {
            System.out.println("Black wins. - with " + winnerBlack);
        } else if (valueBlack < valueWhite) {
            System.out.println("White wins. - with " + winnerWhite);
        } else if (valueBlack == valueWhite) {
            //check the multiple tied cases
            tied(black, white);
        }
    }

    private static void tied(Black black, White white) {
        tieStraightFlush(black, white);
        tie4Kind(black, white);
        tieFullHouse(black, white);
        tieFlush(black, white);
        tieStraight(black, white);
        tie3Kind(black, white);
        tie2Pair(black, white);
        tiePair(black, white);
        if (valueBlack < 15 && valueWhite < 15)//2 through Ace value get highest card
            nextHighestCard(black, white);
    }

    private static void tieStraightFlush(Black black, White white) {
        if (valueBlack == 22 && valueWhite == 22) 
           tieNothingInHand(black, white);     
    }

    private static void tie4Kind(Black black, White white) {
        if (valueBlack == 21 && valueWhite == 21) {
            if (black.tieFourKindValue() > white.tieFourKindValue()) {
                System.out.println("Black wins. - with: "+ winnerBlack);
            } else if (black.tieFourKindValue() < white.tieFourKindValue()) {
                System.out.println("White wins. - with: "+ winnerWhite);
            } else if (black.tieFourKindValue() == white.tieFourKindValue()) {
                tieNothingInHand(black, white);
            }
        }
    }

    private static void tieFullHouse(Black black, White white) {
        if (valueBlack == 20 && valueWhite == 20) {
            if (black.tieThreeKindValue() > white.tieThreeKindValue()) {
                System.out.println("Black wins. - with " + winnerBlack);
            } else if (black.tieThreeKindValue() < white.tieThreeKindValue()) {
                System.out.println("White wins. - with " + winnerWhite);
            } else if (black.tieThreeKindValue() == white.tieThreeKindValue()) {
                tieNothingInHand(black, white);
            }
        }
    }

    private static void tieFlush(Black black, White white) {
        if (valueBlack == 19 && valueWhite == 19) {
            tieNothingInHand(black, white);
        }
    }

    private static void tieStraight(Black black, White white) {
        if (valueBlack == 18 && valueWhite == 18) {
            tieNothingInHand(black, white);
        }
    }

    private static void tie3Kind(Black black, White white) {
        if (valueBlack == 17 && valueWhite == 17) {
            if (black.tieThreeKindValue() > white.tieThreeKindValue()) {
                System.out.println("Black wins. - with: " + winnerBlack);
            } else if (black.tieThreeKindValue() < white.tieThreeKindValue()) {
                System.out.println("White wins. - with: " + winnerWhite);
            } else if (black.tieThreeKindValue() == white.tieThreeKindValue()) {
                tieNothingInHand(black, white);
            }
        }
    }

    private static void tie2Pair(Black black, White white) {
        if (valueBlack == 16 && valueWhite == 16) {
            if (black.tie2PairValue() > white.tie2PairValue()) {
                System.out.println("Black wins. - with: " + winnerBlack);
            } else if (black.tie2PairValue() < white.tie2PairValue()) {
                System.out.println("White wins. - with: " + winnerWhite);
            } else if (black.tie2PairValue() == white.tie2PairValue()) {
                tieNothingInHand(black, white);
            }
        }
    }

    private static void tiePair(Black black, White white) {
        if (valueBlack == 15 && valueWhite == 15) {
            if (black.tiePairValue() > white.tiePairValue()) {
                System.out.println("Black wins. - with: " + winnerBlack);
            } else if (black.tiePairValue() < white.tiePairValue()) {
                System.out.println("White wins. - with: " + winnerWhite);
            } else if (black.tiePairValue() == white.tiePairValue()) {
                tieNothingInHand(black, white);//if nothing in hand and tied go check for highest card
            }
        }
    }

    private static void tieNothingInHand(Black black, White white) {
        int blackHand = black.highCard().getCardRankValue();
        int whiteHand = white.highCard().getCardRankValue();
        if (blackHand > whiteHand) {
            System.out.println("Black wins. - with high card: " + winnerBlack);
        } else if (blackHand < whiteHand) {
            System.out.println("White wins. - with high card: " + winnerWhite);
        } else if (blackHand == whiteHand && blackHand > 0 && whiteHand > 0) {
            //if no hand and highest card is same value go to next highest card
            nextHighestCard(black, white);
        }
    }

    private static void nextHighestCard(Black black, White white) {
        int blackHand = black.nextHighestCard().getCardRankValue();
        int whiteHand = white.nextHighestCard().getCardRankValue();
        if (blackHand > whiteHand) {
            System.out.println("Black wins. - with next highest card: " + black.nextHighestCard().getCardRankValue());
        } else if (blackHand < whiteHand) {
            System.out.println("White wins. - with next highest card: " + white.nextHighestCard().getCardRankValue());
        } else if (blackHand == whiteHand ) {
            
            //nextHighestCard(black, white);
            //System.out.println("Tie. white: " + winnerWhite + " black: "  + winnerBlack);
            
            //need recursive statement here
            
        }
        
    }
    
    public static void winnerBlack(Black black) {
        if (black.straightFlush()) {
            winnerBlack = "StraightFlush: "+ black.highCard();
            valueBlack = 22;
        } else if (black.fourKind()) {
            winnerBlack = "Four of a Kind: " + black.tieFourKindValue();
            valueBlack = 21;
        } else if (black.fullHouse()) {
            winnerBlack = "Full House: " + black.tieThreeKindValue() + " over " + black.tiePairValue();
            valueBlack = 20;
        } else if (black.flush()) {
            winnerBlack = "Flush: " + black.highCard() ;
            valueBlack = 19;
        } else if (black.straight()) {
            winnerBlack = "Straight: " + black.highCard();
            valueBlack = 18;
        } else if (black.threeKind()) {
            winnerBlack = "Three of a Kind: " + black.tieThreeKindValue();
            valueBlack = 17;
        } else if (black.twoPair()) {
            winnerBlack = "2 Pairs: " + black.tie2PairValue();
            valueBlack = 16;
        } else if (black.pair()) {
            winnerBlack = "Pair: " + black.tiePairValue();
            valueBlack = 15;
        } else {
            winnerBlack = "" + black.highCard().getCardName();
            valueBlack = black.highCard().getCardRankValue();//value ranges from 2-14
        }
    }

    public static void winnerWhite(White white) {
        if (white.straightFlush()) {
            winnerWhite = "Straight Flush: " + white.highCard();
            valueWhite = 22;
        } else if (white.fourKind()) {
            winnerWhite = "Four of a Kind: " + white.tieFourKindValue();
            valueWhite = 21;
        } else if (white.fullHouse()) {
            winnerWhite = "Full House: " + white.tieThreeKindValue() + " over " + white.tiePairValue();
            valueWhite = 20;
        } else if (white.flush()) {
            winnerWhite = "Flush: "  + white.highCard();
            valueWhite = 19;
        } else if (white.straight()) {
            winnerWhite = "Straight: "+ white.highCard();
            valueWhite = 18;
        } else if (white.threeKind()) {
            winnerWhite = "Three of a Kind: " + white.tieThreeKindValue();
            valueWhite = 17;
        } else if (white.twoPair()) {
            winnerWhite = "2 Pairs: " + white.tie2PairValue();
            valueWhite = 16;
        } else if (white.pair()) {
            winnerWhite = "Pair: " + white.tiePairValue();
            valueWhite = 15;
        } else {
            winnerWhite = "" + white.highCard().getCardName();
            valueWhite = white.highCard().getCardRankValue();
        }
    }
}//end of Winner class
