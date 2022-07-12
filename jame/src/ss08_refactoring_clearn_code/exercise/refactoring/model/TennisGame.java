package ss08_refactoring_clearn_code.exercise.refactoring.model;

import org.jetbrains.annotations.NotNull;

public class TennisGame {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static String getScore(String namePlayer1, String namePlayer2, int scoreOfPlayer1, int scoreOfPlayer2) {
        String nameScore = "";

        int difference = scoreOfPlayer1 - scoreOfPlayer2;

        if (difference == 0) {
            nameScore = getNameScore(scoreOfPlayer1) + "-all";
        } else {

            if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {

                if (difference == 1) nameScore = " Advantage " + namePlayer1;
                else if (difference == -1) nameScore = "Advantage " + namePlayer2;
                else if (difference > 1) nameScore = "Win for " + namePlayer1;
                else nameScore = "Win for " + namePlayer2;

            } else {
                for (int i = 1; i < 3; i++) {

                    if (i == 1) {
                        nameScore = getNameScore(scoreOfPlayer1);
                    } else {
                        nameScore += "-";
                        nameScore += getNameScore(scoreOfPlayer2);
                    }
                }

            }
        }

        return nameScore;
    }

    @NotNull
    private static String getNameScore(int scoreOfPlayer) {
        String nameScore;
        switch (scoreOfPlayer) {
            case ZERO:
                nameScore = "Love";
                break;
            case ONE:
                nameScore = "Fifteen";
                break;
            case TWO:
                nameScore = "Thirty";
                break;
            case THREE:
                nameScore = "Forty";
                break;
            default:
                nameScore = "Deuce";
                break;

        }
        return nameScore;
    }

    public static void main(String[] args) {
        System.out.println(getScore("ĐẠT", "HUÂN", 4, 5));
    }
}