package lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl;

import lk.ijse.royal.dao.crudDAO.customDAO.QueryDAO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Student;
import lk.ijse.royal.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public Student getStudent(String id)throws Exception{
        Transaction tx=null;
        Student student=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()) {
            tx=ss.beginTransaction();

            student=ss.get(Student.class,id);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
  System.out.println("QueryDAOImpl  Student");
        return student;
    }

    @Override
    public Course getCourse(String code) throws Exception {
        Transaction tx=null;
        Course course=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()) {
            tx=ss.beginTransaction();

            course=ss.get(Course.class,code);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
        System.out.println("QueryDAOImpl  Course");
        return course;
    }
}
