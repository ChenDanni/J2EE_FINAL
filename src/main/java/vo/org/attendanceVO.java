package vo.org;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class attendanceVO {

    public int cardId;
    public int state;//是否是会员
    public String name;
    public List<Integer> lessonid;
    public List<Integer> attendances;
    public int score;
    public int cmstate; //是否退课

    public attendanceVO(int cardId, int state, String name, List<Integer> lessonid, List<Integer> attendances, int score, int cmstate) {
        this.cardId = cardId;
        this.state = state;
        this.name = name;
        this.lessonid = lessonid;
        this.attendances = attendances;
        this.score = score;
        this.cmstate = cmstate;
    }
}
