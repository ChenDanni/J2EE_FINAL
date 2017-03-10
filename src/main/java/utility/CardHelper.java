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

}
