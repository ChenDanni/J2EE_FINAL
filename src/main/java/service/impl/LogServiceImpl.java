package service.impl;

import dao.CardDAO;
import dao.ClassDAO;
import dao.LogDAO;
import dao.OrgDAO;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LogService;
import vo.manager.LogVO;

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
}
