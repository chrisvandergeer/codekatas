package codekatas.bowling;

public class Turn {

    private final String score;
    private Turn nextTurn;

    public Turn(String score) {
        this.score = score;
    }

    public Integer calculateScore() {
        return getFirstRollScore() + getSecondRollScore() + calculateAdditionalScore();
    }

    private Integer calculateAdditionalScore() {
        if (isSpair()) {
            return hasNextTurn() ? nextTurn.getFirstRollScore() : parseScore(score.charAt(2));
        }
        if (isStrike()) {
            Integer score = nextTurn.getFirstAndSecondRollScore();
            if (nextTurn.isStrike()) {
                score = score + nextTurn.nextTurn.getFirstAndSecondRollScore();
                return score;
            }
        }
        return 0;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    public boolean hasNextTurn() {
        return nextTurn != null;
    }

    public boolean isStrike() {
        return score.charAt(0) == 'X';
    }

    public boolean isSpair() {
        return score.length() > 1 && score.charAt(1) == '/';
    }

    public Integer getFirstRollScore() {
        if (isStrike()) {
            return 10;
        }
        return parseScore(score.charAt(0));
    }

    public Integer getSecondRollScore() {
        if (score.length() > 1) {
            if (isSpair()) {
                return 10 - getFirstRollScore();
            }
            return parseScore(score.charAt(1));
        } else {
            return 0;
        }
    }

    public Integer getFirstAndSecondRollScore() {
        return getFirstRollScore() + getSecondRollScore();
    }

    private Integer parseScore(Character rollScore) {
        if (rollScore == '-') {
            return 0;
        }
        return Integer.parseInt(rollScore.toString());
    }

}
