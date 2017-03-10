package vo.member;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by cdn on 17/3/9.
 */

public class courseVO implements Serializable{

    public int id;
    public String name;
    public int price;
    public int memberNum;
    public String learn_time;
    public String orgName;
    public Date start_time;

    public courseVO(int id,String name, int price, int memberNum, String learn_time, String orgName, Date start_time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.memberNum = memberNum;
        this.learn_time = learn_time;
        this.orgName = orgName;
        this.start_time = start_time;
    }
}
