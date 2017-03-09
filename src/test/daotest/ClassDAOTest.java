package daotest;

import base.BaseTest;
import dao.ClassDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cdn on 17/3/9.
 */
public class ClassDAOTest extends BaseTest{
    @Autowired
    ClassDAO classDAO;

    @Test
    public void testAddClass(){
        System.out.println(classDAO.findAll().getClass());

    }
}
