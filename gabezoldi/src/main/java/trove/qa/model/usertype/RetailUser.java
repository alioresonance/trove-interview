package trove.qa.model.usertype;

import trove.qa.model.common.User;
import trove.qa.model.common.Address;

public class RetailUser {
    public static User user() {
        User retail = new User();
        retail.setFirstname("RonRetail");
        retail.setLastname("WMQA");
        retail.setEmail("ronretailwmqa@gmail.com");
        retail.setPassword(User.DEFAULT_PASSWORD);
        retail.setConfirmPassword(User.DEFAULT_PASSWORD);
        retail.setStayUpdated(true);
        retail.setBillingAddress(Address.MAIN_ST_MILPITAS);
        retail.setShippingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        retail.setUserType(UserType.RETAIL);
        return retail;
    }
}
