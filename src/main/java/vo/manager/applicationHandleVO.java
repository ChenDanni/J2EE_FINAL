package vo.manager;

import java.sql.Date;

/**
 * Created by cdn on 17/3/13.
 */
public class applicationHandleVO {

    public int id;
    public String name;
    public String orgName;
    public int state;
    public Date start_time;

    public applicationHandleVO(int id, String name, String orgName, int state, Date start_time) {
        this.id = id;
        this.name = name;
        this.orgName = orgName;
        this.state = state;
        this.start_time = start_time;
    }
}
