
public class TennisGame1 implements TennisGame {

    StringBuilder score = new StringBuilder();

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    final String player1Name;
    final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase("player1"))
            scorePlayer1 += 1;

        if (playerName.equalsIgnoreCase("player2"))
            scorePlayer2 += 1;
    }

    public String getScore() {
        if (istheSameScore(scorePlayer1, scorePlayer2)) {
            return getScoreTie(scorePlayer1);
        }

        if (isMaxScore()) {
            return getAdvantagePlayer(scorePlayer1 - scorePlayer2);
        }

        getTemporalScore();

        return score.toString();
    }

    private void getTemporalScore() {
        int tempScore;

        for (int i = 1; i < 3; i++) {
            if (i == 1)
                tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;
            }
            getScoreTemporal(tempScore);
        }
    }

    private boolean isMaxScore() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean istheSameScore(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 == scorePlayer2;
    }

    private void getScoreTemporal(int tempScore) {
        switch (tempScore) {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            case 3:
                score.append("Forty");
                break;
            default:
                break;
        }
    }

    private String getAdvantagePlayer(int minusResult) {
        switch (minusResult) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (minusResult >= 2)? "Win for player1" : "Win for player2";
        }
    }

    private String getScoreTie(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
