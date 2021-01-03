package lk.ijse.royal.bo.customBO.customBOImpl;

import lk.ijse.royal.bo.customBO.CourseBO;
import lk.ijse.royal.dao.DAOFactory;
import lk.ijse.royal.dao.crudDAO.customDAO.CourseDAO;
import lk.ijse.royal.dto.CourseDTO;
import lk.ijse.royal.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    //
    CourseDAO dao= (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DtoType.COURSE);
    //
    private static List<CourseDTO> newArr=null;
    //
    @Override
    public void save(CourseDTO e) throws Exception {
        dao.save(new Course(e.getCode(),e.getCourseName(),e.getCourseType(),e.getDuration()));
    }

    @Override
    public void update(CourseDTO e) throws Exception {
        dao.update(new Course(e.getCode(),e.getCourseName(),e.getCourseType(),e.getDuration()));
    }

    @Override
    public void delete(String s) throws Exception {
        dao.delete(s);
    }

    @Override
    public CourseDTO getEntity(String s) throws Exception {
       Course c=dao.getEntity(s);
       CourseDTO courseDTO =null;

       if (c!=null) courseDTO = new CourseDTO(c.getCode(), c.getCourseName(), c.getCourseType(), c.getDuration());
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<Course> cc=dao.getAll();
        newArr=new ArrayList<>();

        for (Course c : cc ) {
            CourseDTO course=new CourseDTO(c.getCode(),c.getCourseName(),c.getCourseType(),c.getDuration());
            newArr.add(course);
        }

        return newArr;
    }
}
