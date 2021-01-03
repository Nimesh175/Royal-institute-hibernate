package lk.ijse.royal.bo;

import lk.ijse.royal.bo.customBO.StudentBO;
import lk.ijse.royal.bo.customBO.customBOImpl.CourseBOImpl;
import lk.ijse.royal.bo.customBO.customBOImpl.RegistrationBOImpl;
import lk.ijse.royal.bo.customBO.customBOImpl.StudentBOImpl;

public class BOFactory {
    public static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory==null) boFactory=new BOFactory();
        return boFactory;
    }

    public enum BOType{
        STUDENT,
        COURSE,
        REGISTRAITION
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return new StudentBOImpl();
            case COURSE:
                return new CourseBOImpl();
            case REGISTRAITION:
                return new RegistrationBOImpl();
        }
        return null;
    }


}
