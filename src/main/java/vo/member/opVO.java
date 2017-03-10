package vo.member;

import java.util.Date;

/**
 * Created by cdn on 17/3/10.
 */
public class opVO {
    public String name;
    public int charge;
    public int balance;
    public Date time;

    public opVO(String name, int charge, int balance, Date time) {
        this.name = name;
        this.charge = charge;
        this.balance = balance;
        this.time = time;
    }
}
