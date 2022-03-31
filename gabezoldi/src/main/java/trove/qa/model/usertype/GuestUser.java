package trove.qa.model.usertype;

import trove.qa.model.common.User;
import trove.qa.model.common.Address;

public class GuestUser {
    public static User user() {
        User guest = new User();
        guest.setFirstname("GaryGuest");
        guest.setLastname("WM");
        guest.setEmail("garyguestwmqa@gmail.com");
        guest.setPassword(User.DEFAULT_PASSWORD);
        guest.setConfirmPassword(User.DEFAULT_PASSWORD);
        guest.setStayUpdated(false);
        guest.setBillingAddress(Address.MAIN_ST_MILPITAS);
        guest.setShippingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        guest.setUserType(UserType.GUEST);
        return guest;
    }

    public static User randomUser() {
        long unique = System.currentTimeMillis();
        User randomUser = new User();
        randomUser.setFirstname("Random" + unique);
        randomUser.setLastname("User" + unique);
        randomUser.setEmail("garyguestwmqa+random" + unique + "@gmail.com");
        randomUser.setPassword(User.DEFAULT_PASSWORD);
        randomUser.setConfirmPassword(User.DEFAULT_PASSWORD);
        randomUser.setStayUpdated(false);
        randomUser.setBillingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        randomUser.setShippingAddress(Address.MAIN_ST_MILPITAS);
        randomUser.setUserType(UserType.GUEST);
        return randomUser;
    }
}
