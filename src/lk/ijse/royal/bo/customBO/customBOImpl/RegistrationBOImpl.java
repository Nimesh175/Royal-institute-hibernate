package lk.ijse.royal.bo.customBO.customBOImpl;

import lk.ijse.royal.bo.customBO.RegistrationBO;
import lk.ijse.royal.dao.DAOFactory;
import lk.ijse.royal.dao.crudDAO.customDAO.QueryDAO;
import lk.ijse.royal.dao.crudDAO.customDAO.RegistrationDAO;
import lk.ijse.royal.dto.RegistrationDTO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Registration;
import lk.ijse.royal.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    //
    RegistrationDAO dao= (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DtoType.REGISTRATION);
    //
    QueryDAO qDao= (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DtoType.QUERY);
    //
    private static List<RegistrationDTO> newArr=null;
    //

    @Override
    public void save(RegistrationDTO e) throws Exception {
        //get through the QueryDAO
        Student student=qDao.getStudent(e.getStudentId());
        Course course=qDao.getCourse(e.getCourseCode());

        dao.save(new Registration(e.getRegNo(),e.getRegDate(),e.getRegFree(),student,course));
    }

    @Override
    public void update(RegistrationDTO e) throws Exception {
        //get through the QueryDAO
        Student student=qDao.getStudent(e.getStudentId());
        Course course=qDao.getCourse(e.getCourseCode());

        dao.update(new Registration(e.getRegNo(),e.getRegDate(),e.getRegFree(),student,course));
    }

    @Override
    public void delete(String s) throws Exception {
        dao.delete(s);
        //Issue-delete All Sudent Record
    }

    @Override
    public RegistrationDTO getEntity(String s) throws Exception {
        Registration e = dao.getEntity(s);
        RegistrationDTO reg = null;

        if (e != null) {
                reg = new RegistrationDTO(
                    e.getRegNo()
                    , e.getRegDate()
                    , e.getRegFree()
                    , e.getStudent().getId()
                    , e.getStudent().getStudentName()
                    , e.getCourse().getCode()
                    , e.getCourse().getCourseName()
                );

        }

        return reg;
    }

    @Override
    public List<RegistrationDTO> getAll() throws Exception {
        List<Registration> ee=dao.getAll();
        newArr=new ArrayList<>();
        RegistrationDTO reg=null;

        for (Registration e : ee ) {
            reg = new RegistrationDTO(
                    e.getRegNo()
                    , e.getRegDate()
                    , e.getRegFree()
                    , e.getStudent().getId()
                    , e.getStudent().getStudentName()
                    , e.getCourse().getCode()
                    , e.getCourse().getCourseName()
            );
            newArr.add(reg);
        }

        return  newArr;
    }
}
