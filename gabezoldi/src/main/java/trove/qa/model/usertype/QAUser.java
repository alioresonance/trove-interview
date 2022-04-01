package trove.qa.model.usertype;

import trove.qa.model.common.Address;
import trove.qa.model.common.User;

public class QAUser {
    public static User firstTimeUser() {
        User firstime = new User();
        firstime.setFirstname("FirstTime");
        firstime.setLastname("User");
        firstime.setFullname("FirstTime User");
        firstime.setEmail("first-time-user@trove.co");
        firstime.setPassword(User.DEFAULT_PASSWORD);
        firstime.setConfirmPassword(User.DEFAULT_PASSWORD);
        firstime.setStayUpdated(false);
        firstime.setBillingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        firstime.setShippingAddress(Address.MAIN_ST_MILPITAS);
        firstime.setUserType(UserType.RETAIL);
        return firstime;
    }
}
