package vo.member;

/**
 * Created by cdn on 17/3/11.
 */
public class setCardInfoVO {

    public String username;
    public String accountId;
    public String phone;
    public String password;

    public setCardInfoVO(String username, String accountId, String phone, String password) {
        this.username = username;
        this.accountId = accountId;
        this.phone = phone;
        this.password = password;
    }
}
