package trove.qa.model.report.inputs;

import java.util.Arrays;

public enum TimePeriod {
    LAST_WEEK  ("Last Week"),
    YESTERDAY  ("Yesterday"),
    THIS_MONTH ("This Month"),
    LAST_MONTH ("Last Month"),
    ALL_TIME   ("All Time"),
    CUSTOM     ("Custom");

    private final String name;

    TimePeriod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TimePeriod getAny() {
        return Arrays.stream(TimePeriod.values()).skip((int)(TimePeriod.values().length * Math.random())).findAny().get();
    }
}