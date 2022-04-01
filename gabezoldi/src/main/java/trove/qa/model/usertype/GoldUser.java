package trove.qa.model.usertype;

import trove.qa.model.common.User;
import trove.qa.model.common.Address;

public class GoldUser {
    public static User user() {
        User gold = new User();
        gold.setFirstname("GoldieGold");
        gold.setLastname("WMQA");
        gold.setEmail("goldiegold@gmail.com");
        gold.setPassword(User.DEFAULT_PASSWORD);
        gold.setConfirmPassword(User.DEFAULT_PASSWORD);
        gold.setStayUpdated(false);
        gold.setBillingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        gold.setShippingAddress(Address.MAIN_ST_MILPITAS);
        gold.setUserType(UserType.RETAIL);
        return gold;
    }
}
