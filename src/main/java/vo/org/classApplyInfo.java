package vo.org;

import model.OrganizationEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by cdn on 17/3/11.
 */
public class classApplyInfo {
    public int id;
    public String name;
    public Date time;
    public String teacher;
    public int price;
    public int memberNum;
    public String description;
    public String learnTime;
    public int leftMembers;
    public int orgId;
    public List<lessonInfo> lessons;

    public classApplyInfo(int id, String name, Date time, String teacher, int price, int memberNum, String description, String learnTime, int leftMembers, int orgId, List<lessonInfo> lessons) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.teacher = teacher;
        this.price = price;
        this.memberNum = memberNum;
        this.description = description;
        this.learnTime = learnTime;
        this.leftMembers = leftMembers;
        this.orgId = orgId;
        this.lessons = lessons;
    }
}
