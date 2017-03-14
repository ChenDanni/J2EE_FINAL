package vo.manager;

import java.util.Date;

/**
 * Created by cdn on 17/3/13.
 */
public class LogVO {

    //money = price
    public String username;
    public int cardId;
    public String className;
    public int classId;
    public String orgName;
    public int orgId;
    public int finish;
    public int total;
    public int money;
    public Date time;
    public int state;
    public int money_back;
    public int money_account;

    public LogVO(String username, int cardId, String className, int classId, String orgName, int orgId, int finish, int total, int money, Date time, int state, int money_back, int money_account) {
        this.username = username;
        this.cardId = cardId;
        this.className = className;
        this.classId = classId;
        this.orgName = orgName;
        this.orgId = orgId;
        this.finish = finish;
        this.total = total;
        this.money = money;
        this.time = time;
        this.state = state;
        this.money_back = money_back;
        this.money_account = money_account;
    }
}
