package service;

import vo.org.accountInfoVO;
import vo.org.accountOPVO;
import vo.org.recordDetailVO;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
public interface OrgService {

    public recordDetailVO getRecordDetail(int classId);

    public List<accountOPVO> getAccountOPs(int orgId);

    public accountInfoVO getAccountInfo(int orgId);

}
