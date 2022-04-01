package trove.qa.model;

import java.util.Arrays;

public enum Draft {
    VALID   ("Performance Summary Report", "gabe@zoldi.com", "Blah blah blah...");
    //INVALID ("`~!@#$%^&*()-_=+[{]}\\|;:',<.>/?\"", "johnATgmailOOTcom", "Max Length limit..."),
    //EMPTY   ("", "", ""),
    //NIL     (null, null, null);

    private final String title, author, content;

    Draft(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public static Draft getAny() {
        return Arrays.stream(Draft.values()).skip((int)(Draft.values().length * Math.random())).findAny().get();
    }
}