package lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl;

import lk.ijse.royal.dao.crudDAO.customDAO.StudentDAO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Student;
import lk.ijse.royal.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    //
    private static List<Student> list=null;
    //

    @Override
    public void save(Student entity) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            ss.save(entity);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("StudentDAO SAVE - Failed : "+ex);
        }
    }

    @Override
    public void update(Student entity) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            ss.update(entity);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("StudentDAO Update - Failed : "+ex);
        }
    }

    @Override
    public void delete(String s) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

//            Student student=ss.get(Student.class,s);
//            ss.delete(student);

            ss.createNativeQuery("delete from Student where id='"+s+"'",Student.class).executeUpdate();


            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("StudentDAO Delete - Failed : "+ex);
        }
    }

    @Override
    public Student getEntity(String s) throws Exception {
        Transaction tx=null;
        Student student=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            student=ss.get(Student.class,s);
            System.out.println("test :"+student);
            if (student==null) return new Student("","","","","","");


            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("StudentDAO getEntity - Failed : "+ex);
        }
        return student;
    }

    @Override
    public List<Student> getAll() throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            //Get ALL
            list = ss.createNativeQuery("SELECT * FROM student", Student.class).list();

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("StudentDAO getAll - Failed : "+ex);
        }
        return list;
    }
}
