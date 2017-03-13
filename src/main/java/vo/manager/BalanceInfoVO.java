package vo.manager;

/**
 * Created by cdn on 17/3/13.
 */
public class BalanceInfoVO {

    public int recharge;
    public int memberHandle;
    public int orgHandle;
    public int balance;

    public BalanceInfoVO(int recharge, int memberHandle, int orgHandle) {
        this.recharge = recharge;
        this.memberHandle = memberHandle;
        this.orgHandle = orgHandle;
        this.balance = recharge - memberHandle - orgHandle;
    }
}
