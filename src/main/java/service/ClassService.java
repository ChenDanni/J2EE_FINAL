package service;

import vo.member.BookingVO;
import vo.member.courseDetailVO;
import vo.member.courseVO;

import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
public interface ClassService {

    public List<courseVO> getAllCoursesBrief();

    public courseDetailVO getCourseDetail(int courseId, int cardId);

    public List<BookingVO> getBookings(int cardId);

    public boolean bookCourse(int classId, int cardId);
}
