package trove.qa.model.common;

import java.util.Arrays;

public enum Address {
    MAIN_ST_MILPITAS ("QAFirst1", "QALast1", "100 S Main St", "Unit #101", "Milpitas", State.CA, "95035", "4085551111"),
    FRANKLIN_ST_MOUNTAIN_VIEW ("QAFirst2", "QALast2", "585 Franklin St", "", "Mountain View", State.CA, "94041", "4085552222"),
    EMPTY ("", "", "", "", "",   State.EMPTY, "", ""),
    NULL (null, null, null, null, null,   State.NULL, null, null);

    private final String firstname;
    private final String lastname;
    private final String address1;
    private final String address2;
    private final String city;
    private final State state;
    private final String zip;
    private final String phone;

    Address(String firstname, String lastname, String address1, String address2, String city, State state, String zip, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public String getCity() {
        return city;
    }
    public State getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone() {
        return phone;
    }

    public static State getAny() {
        return Arrays.stream( State.values()).skip((int)(State.values().length * Math.random()) ).findAny().get();
    }
}