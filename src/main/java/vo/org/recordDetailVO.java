package vo.org;

import java.sql.Date;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class recordDetailVO {

    public int totalMember;
    public int price;
    public String learn_time;
    public Date start_time;
    public List<abstanceVO> abstanceVOs;

    public recordDetailVO(int totalMember, int price, String learn_time, Date start_time, List<abstanceVO> abstanceVOs) {
        this.totalMember = totalMember;
        this.price = price;
        this.learn_time = learn_time;
        this.start_time = start_time;
        this.abstanceVOs = abstanceVOs;
    }
}
