package service.impl;

import dao.ClassDAO;
import model.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClassService;
import vo.member.courseVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    ClassDAO classDAO;

    @Override
    public List<courseVO> getAllCoursesBrief() {
        List<ClassEntity> classEntities = classDAO.findAll();
        List<courseVO> ret = new ArrayList<>();

        for (int i = 0;i < classEntities.size();i++) {
            ClassEntity c = classEntities.get(i);
            String orgName = c.getOrgId().getName();
            courseVO vo = new courseVO(c.getName(), c.getPrice(), c.getMemberNum(), c.getLearnTime(), orgName, c.getTime());
            ret.add(vo);
        }
        return ret;
    }
}
