package trove.qa.model.report;

import java.util.Arrays;

public enum ReportSelection {
    PERFORMANCE_SUMMARY_REPORT ("Performance Summary Report"),
    PERFORMANCE_DETAIL_REPORT  ("Performance Detail Report");

    private final String option;

    ReportSelection(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static ReportSelection getAny() {
        return Arrays.stream(ReportSelection.values()).skip((int)(ReportSelection.values().length * Math.random())).findAny().get();
    }
}