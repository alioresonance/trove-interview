package trove.qa.model.report.inputs;

import java.util.Arrays;

public enum AdditionalColumns {
    NONE                     ("None"),
    CREATIVE_NAME            ("Creative Name"),
    DEVICE                   ("Device"),
    CREATIVE_NAME_AND_DEVICE ("Creative Name & Device");

    private final String name;

    AdditionalColumns(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AdditionalColumns getAny() {
        return Arrays.stream(AdditionalColumns.values()).skip((int)(AdditionalColumns.values().length * Math.random())).findAny().get();
    }
}