package vo.manager;

import java.util.Date;

/**
 * Created by cdn on 17/3/13.
 */
public class OrgHandleLogVO {
    public int orgId;
    public int money;
    public int classId;
    public Date time;
    public int orgHandle;

    public OrgHandleLogVO(int orgId, int money, int classId, Date time, int orgHandle) {
        this.orgId = orgId;
        this.money = money;
        this.classId = classId;
        this.time = time;
        this.orgHandle = orgHandle;
    }
}
