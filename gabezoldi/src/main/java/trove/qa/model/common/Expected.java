package trove.qa.model.common;

import lombok.Data;
import trove.qa.model.draft.Draft;

@Data
public class Expected {
    public static User user;
    public static String orderName;
    public static Draft draft;
}