package service;

import vo.manager.applicationHandleVO;
import vo.member.BookingVO;
import vo.member.LearningVO;
import vo.member.courseDetailVO;
import vo.member.courseVO;
import vo.org.applyInfoVO;
import vo.org.classApplyInfo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
public interface ClassService {

    //0:learn  1:finishing
    public List<LearningVO> getLearnings(int cardId,int type);

    public boolean setApplicationSuccess(int classId);

    public boolean setApplicationFail(int classId);

    public List<applicationHandleVO> getApplicationHandle();

    public boolean startCourse(int classId);

    public List<courseVO> getStartCourse(int orgId);

    public List<applyInfoVO> getApplyInfo(int orgId);

    public List<courseVO> getAllCoursesBrief();

    public List<courseVO> getOrgCoursesBrief(int orgId);

    public courseDetailVO getCourseDetail(int courseId, int cardId);

    public List<BookingVO> getBookings(int cardId);

    public boolean bookCourse(int classId, int cardId);

    public boolean applyCourse(classApplyInfo ac);


}
