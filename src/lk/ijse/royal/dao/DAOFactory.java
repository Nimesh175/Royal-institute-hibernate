package lk.ijse.royal.dao;

import lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl.CourseDAOImpl;
import lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl.QueryDAOImpl;
import lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl.RegistrationDAOImpl;
import lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public static DAOFactory getInstance(){
        if (daoFactory==null) daoFactory=new DAOFactory();
        return daoFactory;
    }

    public enum DtoType{
        STUDENT,
        COURSE,
        REGISTRATION,
        QUERY
    }

    public SuperDAO getDAO(DtoType dtoType){
        switch (dtoType){
            case STUDENT:
                return new StudentDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
        }
        return null;
    }
}
