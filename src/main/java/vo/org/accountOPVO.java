package vo.org;

import java.util.Date;

/**
 * Created by cdn on 17/3/14.
 */
public class accountOPVO {

    public int classId;
    public String className;
    public int state;
    public int money;
    public int balance;
    public Date time;
    public int cardId;

    public accountOPVO(int classId, String className, int state, int money, int balance, Date time, int cardId) {
        this.classId = classId;
        this.className = className;
        this.state = state;
        this.money = money;
        this.balance = balance;
        this.time = time;
        this.cardId = cardId;
    }
}
