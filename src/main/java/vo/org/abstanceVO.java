package vo.org;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public class abstanceVO {

    public int cardId;
    public String name;
    List<Integer> abstances;

    public abstanceVO(int cardId, String name, List<Integer> abstances) {
        this.cardId = cardId;
        this.name = name;
        this.abstances = abstances;
    }
}
