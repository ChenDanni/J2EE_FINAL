package vo.org;

import java.sql.Date;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class recordDetailVO {

    public String course_name;
    public int totalMember;
    public int price;
    public String learn_time;
    public Date start_time;
    public List<attendanceVO> attendanceVOs;

    public recordDetailVO(String course_name, int totalMember, int price, String learn_time, Date start_time, List<attendanceVO> attendanceVOs) {
        this.course_name = course_name;
        this.totalMember = totalMember;
        this.price = price;
        this.learn_time = learn_time;
        this.start_time = start_time;
        this.attendanceVOs = attendanceVOs;
    }
}
