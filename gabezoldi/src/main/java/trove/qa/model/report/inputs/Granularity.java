package trove.qa.model.report.inputs;

import java.util.Arrays;

public enum Granularity {
    SUMMARY ("Summary"),
    DAILY   ("Daily"),
    WEEKLY  ("Weekly"),
    MONTHLY ("Monthly"),
    YEARLY  ("Yearly");

    private final String name;

    Granularity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Granularity getAny() {
        return Arrays.stream(Granularity.values()).skip((int)(Granularity.values().length * Math.random())).findAny().get();
    }
}