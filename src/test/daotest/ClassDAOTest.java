package daotest;

import base.BaseTest;
import dao.ClassDAO;
import dao.OrgDAO;
import model.ClassEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
public class ClassDAOTest extends BaseTest{
    @Autowired
    ClassDAO classDAO;
    @Autowired
    OrgDAO orgDAO;

//    @Test
//    public void testAddClass(){
//        System.out.println(classDAO.findAll().getClass());
//
//    }
    @Test
    public void testFindByOrgId(){
        List<ClassEntity> c = classDAO.findClassesByOrg(orgDAO.findOne(9000001));
        System.out.println(c.size());
    }
}
