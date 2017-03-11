package vo.member;

import java.sql.Date;

/**
 * Created by cdn on 17/3/10.
 */
public class BookingVO {
    public int id;
    public String name;
    public int price;
    public int memberNum;
    public int leftMembers;
    public String learn_time;
    public String orgName;
    public Date start_time;

    public BookingVO(int id, String name, int price, int memberNum, int leftMembers, String learn_time, String orgName, Date start_time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.memberNum = memberNum;
        this.leftMembers = leftMembers;
        this.learn_time = learn_time;
        this.orgName = orgName;
        this.start_time = start_time;
    }
}
