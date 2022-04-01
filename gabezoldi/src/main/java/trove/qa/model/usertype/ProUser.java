package trove.qa.model.usertype;

import trove.qa.model.common.User;
import trove.qa.model.common.Address;

public class ProUser {
    public static User user() {
        User pro = new User();
        // TODO: Peter Pro user account is just a Retail account; it's not setup in the backend to be a Pro Account
        // TODO: Instead got different account from Srini to use for now
        //pro.setFirstname("PeterPro");
        //pro.setEmail("peterpro@gmail.com");
        //pro.setPassword(User.DEFAULT_PASSWORD);
        //pro.setConfirmPassword(User.DEFAULT_PASSWORD);

        pro.setFirstname("ABB4676");
        pro.setEmail("PRO4676@nonprod.trove.com");
        pro.setPassword("Trove2@");
        pro.setConfirmPassword("Trove2@");

        pro.setLastname("TroveQA");
        pro.setStayUpdated(true);
        pro.setBillingAddress(Address.MAIN_ST_MILPITAS);
        pro.setShippingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        pro.setUserType(UserType.PRO);
        return pro;
    }
}
