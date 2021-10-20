package nl.cge.gameoflife;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    private static final String GREEN_COLOR = "\u001B[32m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String RESET_COLOR = "\u001B[0m";

    private static final String ALIVE_STATUS = "O";
    private static final String DEAD_STAUS = "X";
    private static final String UNKNOWN_STATUS = "?";

    private static final Map<String, String> STATE_COLOR_MAP = new HashMap<>();
    static {
        STATE_COLOR_MAP.put(ALIVE_STATUS, GREEN_COLOR);
        STATE_COLOR_MAP.put(DEAD_STAUS, RED_COLOR);
        STATE_COLOR_MAP.put(UNKNOWN_STATUS, YELLOW_COLOR);
    }

    private final String status;

    public Cell(String status) {
        this.status = status;
    }

    public String getStatus() {
        return STATE_COLOR_MAP.get(this.status) + this.status + RESET_COLOR;
    }

    public boolean isAlive() {
        return ALIVE_STATUS.equals(this.status);
    }

    public boolean isDead() {
        return DEAD_STAUS.equals(this.status);
    }
}
