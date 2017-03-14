package service.impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LogService;
import vo.manager.LogVO;
import vo.manager.MemberHandleLogVO;
import vo.manager.OrgHandleLogVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogDAO logDAO;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    OrgDAO orgDAO;
    @Autowired
    MemberHandleLogDAO memberHandleLogDAO;
    @Autowired
    OrgHandleLogDAO orgHandleLogDAO;

    @Override
    public List<LogVO> getMemberHandleLog() {

        List<LogVO> vos = new ArrayList<>();
        List<LogEntity> log = logDAO.findAllLogs();

        for (int i = 0;i < log.size();i++){
            LogEntity l = log.get(i);
            CardEntity card = cardDAO.findOne(l.getCardId());
            String username = card.getName();
            ClassEntity classEntity = classDAO.findOne(l.getClassId());
            String classname = classEntity.getName();
            OrganizationEntity org = classEntity.getOrgId();
            String orgname = org.getName();
            int orgid = org.getId();

            LogVO mh = new LogVO(username,l.getCardId(),classname,
                    l.getClassId(),orgname,orgid,l.getFinish(),l.getTotal(),
                    l.getMoney(),l.getTime(),l.getState(),l.getMoneyBack(),l.getMoneyAccount());
            vos.add(mh);
        }
        return vos;
    }

    @Override
    public List<MemberHandleLogVO> getManagerMemberHandleLog() {

        List<MemberHandleLogVO> vos = new ArrayList<>();

        List<MemberhandleLogEntity> logs = memberHandleLogDAO.findAllLogsOrderByTimeDesc();
        for (int i = 0;i < logs.size();i++){
            MemberhandleLogEntity m = logs.get(i);
            MemberHandleLogVO vo = new MemberHandleLogVO(m.getCardId().getId(),m.getClassId().getId(),m.getMoney(),m.getMemberhandle(),m.getTime());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<OrgHandleLogVO> getManagerOrgHandleLog() {
        List<OrgHandleLogVO> vos = new ArrayList<>();

        List<OrghandleLogEntity> logs = orgHandleLogDAO.findAllLogsOrderByTimeDesc();
        for (int i = 0;i < logs.size();i++){
            OrghandleLogEntity m = logs.get(i);
            OrgHandleLogVO vo = new OrgHandleLogVO(m.getOrgId().getId(),m.getMoney(),m.getClassId().getId(),m.getTime(),m.getOrghandle());
            vos.add(vo);
        }
        return vos;
    }
}
