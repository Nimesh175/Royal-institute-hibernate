package lk.ijse.royal.bo.customBO.customBOImpl;

import lk.ijse.royal.bo.BOFactory;
import lk.ijse.royal.bo.customBO.StudentBO;
import lk.ijse.royal.dao.DAOFactory;
import lk.ijse.royal.dao.crudDAO.customDAO.StudentDAO;
import lk.ijse.royal.dto.CourseDTO;
import lk.ijse.royal.dto.StudentDTO;
import lk.ijse.royal.entity.Course;
import lk.ijse.royal.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    //
    StudentDAO dao= (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DtoType.STUDENT);
    //
    private static List<StudentDTO> newArr=null;
    //
    @Override
    public void save(StudentDTO e) throws Exception {
    dao.save(new Student(e.getId(),e.getStudentName(),e.getAddress(),e.getContact(),e.getDob(),e.getGender()));
    }

    @Override
    public void update(StudentDTO e) throws Exception {
        dao.update(new Student(e.getId(),e.getStudentName(),e.getAddress(),e.getContact(),e.getDob(),e.getGender()));
    }

    @Override
    public void delete(String s) throws Exception {
        dao.delete(s);
    }

    @Override
    public StudentDTO getEntity(String s) throws Exception {
        Student e=dao.getEntity(s);
        StudentDTO studentDTO =null;

        if (e!=null) studentDTO = new StudentDTO(e.getId(),e.getStudentName(),e.getAddress(),e.getContact(),e.getDob(),e.getGender());
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        List<Student> cc=dao.getAll();
        newArr=new ArrayList<>();

        for (Student e : cc ) {
            StudentDTO student=new StudentDTO(e.getId(),e.getStudentName(),e.getAddress(),e.getContact(),e.getDob(),e.getGender());
            newArr.add(student);
        }

        return newArr;
    }
}
