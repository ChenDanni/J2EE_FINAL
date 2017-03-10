package service;

import vo.member.courseDetailVO;
import vo.member.courseVO;

import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
public interface ClassService {

    public List<courseVO> getAllCoursesBrief();

    public courseDetailVO getCourseDetail(int courseId, int cardId);

}
