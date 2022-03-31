package trove.qa.model.usertype;

import trove.qa.model.common.Address;
import trove.qa.model.common.User;

public class QAUser {
    public static User user() {
        User qaTester = new User();
        qaTester.setFirstname("QA");
        qaTester.setLastname("Tester");
        qaTester.setEmail("qa-tester@qa-test.com");
        qaTester.setPassword(User.DEFAULT_PASSWORD);
        qaTester.setConfirmPassword(User.DEFAULT_PASSWORD);
        qaTester.setStayUpdated(false);
        qaTester.setBillingAddress(Address.FRANKLIN_ST_MOUNTAIN_VIEW);
        qaTester.setShippingAddress(Address.MAIN_ST_MILPITAS);
        qaTester.setUserType(UserType.RETAIL);
        return qaTester;
    }
}
