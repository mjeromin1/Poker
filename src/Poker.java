 /*
Mike Jeromin

This is a Poker java kata for Manifest Solutions.

http://codingdojo.org/kata/PokerHands/
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Poker {

    public static void main(String[] args) throws IOException {

        //initialize read / add statements for black player
        List<Black> gamesBlack = readBlackFromFile("input.txt");
        List<Hand> handsBlack = readBlackCards("input.txt");
        addBlackHand(gamesBlack, handsBlack, "input.txt");
        //initialize read / add statements for white player
        List<White> gamesWhite = readWhiteFromFile("input.txt");
        List<Hand> handsWhite = readWhiteCards("input.txt");
        addWhiteHand(gamesWhite, handsWhite, "input.txt");

        //read lines from file
        int locationInFile = 0;
        Path pathToFile = Paths.get("input.txt");
        List<String> linesInFile = Files.readAllLines(pathToFile);
        for (Black name : gamesBlack) {
            for (White name2 : gamesWhite) {
                if (linesInFile.get(locationInFile).contains(name.toString())&& linesInFile.get(locationInFile).contains(name2.toString())) {
                    
                    //declare who wins with the hand
                    Winner.whoWins(name, name2);
                    if (locationInFile < linesInFile.size() - 1)
                        locationInFile++;
                }
            }
        }
    }
    
    //file reading methods
    public static List<Black> readBlackFromFile(String file) {
        List<Black> blackGames = new ArrayList<>();
        Path filePath = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            while (line != null) {//while not empty
                String[] split = line.split(" ");//split the lines
                Black black = createBlack(split);//create hands in according player
                blackGames.add(black);//add all games to player
                line = reader.readLine();//read next line
            }
        } catch (IOException e) {}
        return blackGames;
    }
    //duplicate of black...read file
    public static List<White> readWhiteFromFile(String file) {
        List<White> whiteGames = new ArrayList<>();
        Path filePath = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                White white = createWhite(split);
                whiteGames.add(white);
                line = reader.readLine();
            }
        } catch (IOException e) {}
        return whiteGames;
    }
    //read cards from split lines
    public static List<Hand> readBlackCards(String file) {
        List<Hand> cards = new ArrayList<>();
        Path filePath = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            while (line != null) {//while not empty
                String[] split = line.split(" ");//split lines by spacing
                Hand hand = createHandBlack(split);//create hands
                cards.add(hand);//add cards to hand
                line = reader.readLine();//read next line
            }
        } catch (IOException e) {}
        return cards;
    }

    public static List<Hand> readWhiteCards(String file) {
        List<Hand> cards = new ArrayList<>();
        Path filePath = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                Hand hand = createHandWhite(split);
                cards.add(hand);
                line = reader.readLine();
            }
        } catch (IOException e) {}
        return cards;
    }

    private static Hand createHandBlack(String[] line) {//put all five cards into hand
        Card cardOne = new Card(line[1].charAt(0), line[1].charAt(1));
        Card cardTwo = new Card(line[2].charAt(0), line[2].charAt(1));
        Card cardThree = new Card(line[3].charAt(0), line[3].charAt(1));
        Card cardFour = new Card(line[4].charAt(0), line[4].charAt(1));
        Card cardFive = new Card(line[5].charAt(0), line[5].charAt(1));
        return new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);
    }

    private static Hand createHandWhite(String[] line) {
        Card cardOne = new Card(line[8].charAt(0), line[8].charAt(1));
        Card cardTwo = new Card(line[9].charAt(0), line[9].charAt(1));
        Card cardThree = new Card(line[10].charAt(0), line[10].charAt(1));
        Card cardFour = new Card(line[11].charAt(0), line[11].charAt(1));
        Card cardFive = new Card(line[12].charAt(0), line[12].charAt(1));
        return new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);
    }

    private static Black createBlack(String[] line) {
        String black = line[0];//player name
        return new Black(black);
    }

    private static White createWhite(String[] line) {
        String white = line[7];//player name
        return new White(white);
    }
    
    //add split cards into according hands
    public static void addBlackHand(List<Black> games, List<Hand> hands, String file)throws IOException {
        Path filePath = Paths.get(file);
        List<String> lines = Files.readAllLines(filePath);
        int lineNumber = 0;
        for (Black game : games) {
            for (Hand hand : hands) {
                if (lines.get(lineNumber).contains(game.getName())&& lines.get(lineNumber).contains(hand.toString())&& game.getHand().isEmpty()){
                    game.addHand(hand);
                    if (lineNumber < lines.size() - 1)
                        lineNumber++;
                }
            }
        }
    }

    public static void addWhiteHand(List<White> games, List<Hand> hands, String file)throws IOException {
        Path filePath = Paths.get(file);
        List<String> lines = Files.readAllLines(filePath);
        int lineNumber = 0;
        for (White game : games) {
            for (Hand hand : hands) {
                if (lines.get(lineNumber).contains(game.getName())&& lines.get(lineNumber).contains(hand.toString())&& game.getHand().isEmpty()) {
                    game.addHand(hand);
                    if (lineNumber < lines.size() - 1)
                        lineNumber++;
                }
            }
        }
    }

}//end of Poker class
