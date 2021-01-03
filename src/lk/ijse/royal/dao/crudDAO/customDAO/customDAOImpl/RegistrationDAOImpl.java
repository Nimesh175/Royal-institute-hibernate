package lk.ijse.royal.dao.crudDAO.customDAO.customDAOImpl;

import lk.ijse.royal.dao.crudDAO.customDAO.RegistrationDAO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Registration;
import lk.ijse.royal.entity.Student;
import lk.ijse.royal.hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    //
    private static List<Registration> list=null;


    @Override
    public void save(Registration entity) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            ss.save(entity);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("RegistrationDAO SAVE - Failed : "+ex);
        }
    }

    @Override
    public void update(Registration e) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();


            NativeQuery<Registration> nq = ss.createNativeQuery("UPDATE Registration SET regFree ="+e.getRegFree()+"where regNo="+e.getRegNo(), Registration.class);
            nq.executeUpdate();

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("RegistrationDAO Update - Failed : "+ex);
        }
    }

    @Override
    public void delete(String s) throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

          ss.createNativeQuery("delete from Registration where regNo=" + Integer.parseInt(s), Registration.class).executeUpdate();
           // nq.executeUpdate();

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("RegistrationDAO Delete - Failed : "+ex);
        }
    }

    @Override
    public Registration getEntity(String s) throws Exception {
        Transaction tx=null;
        Registration registration=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            //2nd line is Important with if condition
            NativeQuery<Registration> nativeQuery = ss.createNativeQuery("select * from registration where regNo=" + Integer.parseInt(s), Registration.class);
           if (!nativeQuery.list().isEmpty()) registration=nativeQuery.list().get(0);

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("RegistrationDAO getEntity - Failed : "+ex);
        }

        return registration;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        Transaction tx=null;
        try(Session ss= HibernateUtil.getSessionFactory().openSession()){
            tx=ss.beginTransaction();

            //Get ALL
            list = ss.createNativeQuery("SELECT * FROM Registration", Registration.class).list();

            tx.commit();
        }catch (Exception ex){
            tx.rollback();
            System.out.println("RegistrationDAO getAll - Failed : "+ex);
        }
        return list;
    }
}
