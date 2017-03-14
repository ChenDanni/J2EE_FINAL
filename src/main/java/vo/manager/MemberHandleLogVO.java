package vo.manager;

import java.util.Date;

/**
 * Created by cdn on 17/3/15.
 */
public class MemberHandleLogVO {

    public int cardId;
    public int classId;
    public int money;
    public int memberhandle;
    public Date time;

    public MemberHandleLogVO(int cardId, int classId, int money, int memberhandle, Date time) {
        this.cardId = cardId;
        this.classId = classId;
        this.money = money;
        this.memberhandle = memberhandle;
        this.time = time;
    }
}
