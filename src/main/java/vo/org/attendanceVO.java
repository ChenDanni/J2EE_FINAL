package vo.org;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class attendanceVO {

    public int cardId;
    public String name;
    public List<Integer> attendances;

    public attendanceVO(int cardId, String name, List<Integer> attendances) {
        this.cardId = cardId;
        this.name = name;
        this.attendances = attendances;
    }
}
