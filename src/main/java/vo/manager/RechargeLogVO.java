package vo.manager;


import java.util.Date;

/**
 * Created by cdn on 17/3/13.
 */
public class RechargeLogVO {

    public int cardId;
    public int money;
    public Date time;
    public int recharge; //账户充值累计

    public RechargeLogVO(int cardId, int money, Date time, int recharge) {
        this.cardId = cardId;
        this.money = money;
        this.time = time;
        this.recharge = recharge;
    }
}
