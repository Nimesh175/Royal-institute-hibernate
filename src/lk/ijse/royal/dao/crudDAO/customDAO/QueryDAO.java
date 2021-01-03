package lk.ijse.royal.dao.crudDAO.customDAO;

import lk.ijse.royal.dao.SuperDAO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Student;

public interface QueryDAO extends SuperDAO {
    public Student getStudent(String id)throws Exception;
    public Course getCourse(String code)throws Exception;
}
