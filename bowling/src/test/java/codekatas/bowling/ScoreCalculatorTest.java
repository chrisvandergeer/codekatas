package codekatas.bowling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCalculatorTest {

    @CsvSource(value = {
            "12 12 12 12 12 12 12 12 12 12,   30",
            "1- 1- 1- 1- 1- 1- 1- 1- 1- 1-,   10",
            "X X X X X X X X X X X X,        300",
            "-- -- -- -- -- -- -- -- -- --,    0",
            "5/ -- -- -- -- -- -- -- -- --,   10",
            "5/ 5- -- -- -- -- -- -- -- --,   20",
            "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5, 150",
            "X X X X X X X X X X X 3       , 293"
    })
    @ParameterizedTest
    void test(String scoreList, Integer expectedTotal) {
        Integer totalScore = new ScoreCalculator().calculate(scoreList);
        assertEquals(expectedTotal, totalScore);
    }

}
