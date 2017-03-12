package utility;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/12.
 */
public class OrgHelper {
    public static int getCurrentOrgId(HttpSession session){
        int orgId = -1;
        if (session.getAttribute("orgId") != null){
            orgId = (int)session.getAttribute("orgId");
        }
        return orgId;
    }
}
