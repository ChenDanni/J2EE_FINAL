package daotest;

import base.BaseTest;
import dao.ClassMemberDAO;
import model.ClassMemberEntity;
import model.ClassMemberEntityPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by cdn on 17/3/10.
 */
public class ClassMemberDAOTest extends BaseTest{

    @Autowired
    ClassMemberDAO classMemberDAO;

    @Test
    public void testGetOne(){
        System.out.println("in");
        ClassMemberEntityPK classMemberEntityId = new ClassMemberEntityPK();
        classMemberEntityId.setClassId(10000001);
        classMemberEntityId.setCardId(1000001);
        ClassMemberEntity cm = classMemberDAO.findOne(classMemberEntityId);
        System.out.println(cm.getState());
    }


    @Test
    public void testFindByCardIdAndState(){
        Collection<ClassMemberEntity> cms = classMemberDAO.findByCardIdAndState(1000001,0);
        System.out.println(cms);
    }
}
