package Kuis2;
public class Club {
    String name;
    int matchesPlayed;
    int wins;
    int losses;
    int points;

    public Club(String name) {
        this.name = name;
        this.matchesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.points = 0;
    }

    public void recordMatch(boolean isWin) {
        this.matchesPlayed++;
        if (isWin) {
            this.wins++;
            this.points += 2;
        } else {
            this.losses++;
            this.points += 1;
        }
    }

    public String toString() {
        return String.format("%-35s %2d %6d %6d %6d", name, matchesPlayed, wins, losses, points);
    }
}