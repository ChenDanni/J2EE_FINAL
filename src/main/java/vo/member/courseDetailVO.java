package vo.member;

import java.util.Date;

/**
 * Created by cdn on 17/3/10.
 */
public class courseDetailVO {
    public int id;
    public int memberNum;
    public int leftMembers;
    //0已预定
    public int state;
    public String name;
    public int price;
    public String learn_time;
    public String orgName;
    public String teacher;
    public String description;
    public Date start_time;

    public courseDetailVO(int id, int memberNum, int leftMembers, int state, String name, int price, String learn_time, String orgName, String teacher, String description, Date start_time) {
        this.id = id;
        this.memberNum = memberNum;
        this.leftMembers = leftMembers;
        this.state = state;
        this.name = name;
        this.price = price;
        this.learn_time = learn_time;
        this.orgName = orgName;
        this.teacher = teacher;
        this.description = description;
        this.start_time = start_time;
    }
}
