package codekatas.bowling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ScoreCalculator {

    public Integer calculate(String scoreListStr) {
        AtomicReference<Turn> previousTurn = new AtomicReference<>();
        List<Turn> scoreList = Arrays.stream(scoreListStr.split(" "))
                .map(Turn::new)
                .peek(turn -> linkTurn(previousTurn, turn))
                .collect(Collectors.toList());
        return scoreList.stream()
                .limit(10)
                .map(Turn::calculateScore)
                .reduce(0, Integer::sum);
    }

    private void linkTurn(AtomicReference<Turn> previousTurn, Turn turn) {
        Turn previous = previousTurn.get();
        if (previous != null) {
            previous.setNextTurn(turn);
        }
        previousTurn.set(turn);
    }
}
