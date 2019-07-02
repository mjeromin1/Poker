 /*
Mike Jeromin
Class White: sets up player 2 and according getter methods for player white.
*/
import java.util.List;

public class White extends Player {
    private String name;

    public White(String name) {
        this.name = name;
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Hand> getHand() {return hands;}
    public void addHand(Hand hand) {hands.add(hand);}

    @Override
    public String toString() {
        return name + " " + getHand().toString().substring(1, getHand().toString().length() - 1);
    }
}//end of White class
