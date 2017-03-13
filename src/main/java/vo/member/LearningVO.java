package vo.member;

import vo.org.attendanceVO;

import java.sql.Date;

/**
 * Created by cdn on 17/3/13.
 */
public class LearningVO {
    public int id;
    public String name;
    public int price;
    public int totalMember;
    public String learn_time;
    public String orgName;
    public Date start_time;
    public attendanceVO attendanceVO;

    public LearningVO(int id, String name, int price, int totalMember, String learn_time, String orgName, Date start_time, vo.org.attendanceVO attendanceVO) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalMember = totalMember;
        this.learn_time = learn_time;
        this.orgName = orgName;
        this.start_time = start_time;
        this.attendanceVO = attendanceVO;
    }
}
