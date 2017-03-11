package utility;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/10.
 */
public class CardHelper {

    public static int getCurrentCardId(HttpSession session){
        int cardId = -1;
        if (session.getAttribute("cardId") != null){
            cardId = (int)session.getAttribute("cardId");
        }
        return cardId;
    }

    /*
       *level
       *1: 0-1000
       *2: 1001-3000
       *3: 3001-10000
       *4: >10001
     */

    public static int getLevel(int consume){
        int[] levels = {0,1000,3000,10000};
        for (int i = 0;i < levels.length;i++){
            if (consume < levels[i])
                return i;
        }
        return levels.length;
    }

    public static int getChargeByPoints(int points){
        return points;
    }

}
