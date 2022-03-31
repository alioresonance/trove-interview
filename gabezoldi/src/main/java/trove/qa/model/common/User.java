package trove.qa.model.common;

import lombok.Data;
import trove.qa.model.usertype.*;

@Data
public class User {

    public final static String DEFAULT_PASSWORD = "sightlyqatest";

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private Boolean stayUpdated;
    private Address billingAddress;
    private Address shippingAddress;
    private UserType userType;

    public static User garyGuest() {
        return GuestUser.user();
    }
    public static User ronRetail() {
        return RetailUser.user();
    }
    public static User peterPro() {
        return ProUser.user();
    }
    public static User silviaSilver() {
        return SilverUser.user();
    }
    public static User goldieGold() {
        return GoldUser.user();
    }
    public static User qaTester() {
        return QAUser.user();
    }
}