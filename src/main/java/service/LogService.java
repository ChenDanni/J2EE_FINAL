package service;

import vo.manager.LogVO;
import vo.manager.MemberHandleLogVO;
import vo.manager.OrgHandleLogVO;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
public interface LogService {

    public List<LogVO> getMemberHandleLog();

    public List<MemberHandleLogVO> getManagerMemberHandleLog();

    public List<OrgHandleLogVO> getManagerOrgHandleLog();

}
