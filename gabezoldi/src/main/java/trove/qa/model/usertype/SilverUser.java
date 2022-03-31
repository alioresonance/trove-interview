package trove.qa.model.usertype;

import trove.qa.model.common.User;
import trove.qa.model.common.Address;

public class SilverUser {
    public static User user() {
        User silver = new User();
        silver.setFirstname("SilviaSilver");
        silver.setLastname("WMQA");
        silver.setEmail("silviasilverwmqa@gmail.com");
        silver.setPassword(User.DEFAULT_PASSWORD);
        silver.setConfirmPassword(User.DEFAULT_PASSWORD);
        silver.setStayUpdated(false);
        silver.setBillingAddress(Address.MAIN_ST_MILPITAS);
        silver.setShippingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        silver.setUserType(UserType.RETAIL);
        return silver;
    }
}
