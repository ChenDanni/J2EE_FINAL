package vo.org;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class attendanceVO {

    public int cardId;
    public String name;
    public List<Integer> lessonid;
    public List<Integer> attendances;
    public int score;

    public attendanceVO(int cardId, String name, List<Integer> lessonid, List<Integer> attendances, int score) {
        this.cardId = cardId;
        this.name = name;
        this.lessonid = lessonid;
        this.attendances = attendances;
        this.score = score;
    }
}
