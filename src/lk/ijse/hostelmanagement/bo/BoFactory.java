package lk.ijse.hostelmanagement.bo;
/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:20 AM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.bo.custom.impl.LoginBoImpl;
import lk.ijse.hostelmanagement.bo.custom.impl.StudentBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {}

    public static BoFactory getInstance() {
        return (boFactory==null) ? boFactory = new BoFactory() : boFactory;
    }

    public SuperBo getBo(BOType boType) {
        switch (boType) {
            case USER:
                return new LoginBoImpl();
            case STUDENT:
                return new StudentBoImpl();
            default:
                System.out.println("Class Not Found!");
                return null;
        }
    }
}
