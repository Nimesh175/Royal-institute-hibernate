package lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl;

import lk.ijse.royal.dao.crudDAO.customDAO.CourseDAO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Student;
import lk.ijse.royal.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    //
    private static List<Course> list=null;
    //
    @Override
    public void save(Course entity) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
        tx=ss.beginTransaction();

        ss.save(entity);

        tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
    }

    @Override
    public void update(Course entity) throws Exception {
        Transaction tx=null;
        try(Session ss=HibernateUtil.getSessionFactory().openSession()){
         tx=ss.beginTransaction();

         ss.update(entity);

         tx.commit();
        }catch(Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
    }

    @Override
    public void delete(String s) throws Exception {
        Transaction tx=null;
        try(Session ss=HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

//            ss.delete(ss.get(Course.class,s));
            ss.createNativeQuery("delete from Course where code='"+s+"'", Course.class).executeUpdate();

            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
    }

    @Override
    public Course getEntity(String s) throws Exception {
        Transaction tx=null;
        Course course=null;
        try(Session ss=HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            course=ss.get(Course.class,s);
            if (course==null) return new Course("","","","");

            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
        return course;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Transaction tx=null;
        try(Session ss=HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            //Get ALL
            list = ss.createNativeQuery("SELECT * FROM course", Course.class).list();

            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            System.out.println("ex = " + ex);
        }
        return list;
    }
}
