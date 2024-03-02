

import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private final String name;

    public RPS_Player(String name) {
        this.name = name;
        clear();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public double getWinPercentage() {
        if (numberOfGamesPlayed == 0) {
            return 0.0;
        }
        return (double) numberOfGamesWon / numberOfGamesPlayed;
    }

    public void clear() {
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
        choice = -1; // -1 represents no choice made
    }

    public RPS_Player challenge(RPS_Player anotherPlayer) {
        makeRandomChoice();
        anotherPlayer.makeRandomChoice();
        numberOfGamesPlayed++;

        return determineWinner(anotherPlayer);
    }

    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer) {
        if (choice == -1) {
            // If no previous choice made, make a random choice
            makeRandomChoice();
        }

        anotherPlayer.makeRandomChoice();
        //numberOfGamesPlayed++;
        return determineWinner(anotherPlayer);
    }

    private void makeRandomChoice() {
        Random random = new Random();
        choice = random.nextInt(3); // 0 represents rock, 1 represents paper, 2 represents scissors
    }

    private RPS_Player determineWinner(RPS_Player anotherPlayer) {
        int result = (choice - anotherPlayer.choice + 3) % 3;
        anotherPlayer.numberOfGamesPlayed++;
        if (result == 0) {
            // Draw
            return null;
        } else if (result == 1) {
            // This player wins
            numberOfGamesWon++;
            return this;
        } else {
            // Another player wins
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        }
    }
}
