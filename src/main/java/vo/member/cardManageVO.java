package vo.member;

import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
public class cardManageVO {

    public String name;
    public int level;
    public int balance;
    public int points;

    public List<opVO> ops;

    public cardManageVO(String name, int level, int balance, int points, List<opVO> ops) {
        this.name = name;
        this.level = level;
        this.balance = balance;
        this.points = points;
        this.ops = ops;
    }
}
