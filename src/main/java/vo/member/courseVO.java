package vo.member;

import model.LessonEntity;
import model.OrganizationEntity;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by cdn on 17/3/9.
 */

public class courseVO implements Serializable{

    public String name;
    public int price;
    public int memberNum;
    public String learn_time;
    public String orgName;
    public Date create_time;

    public courseVO(String name, int price, int memberNum, String learn_time, String orgName, Date create_time) {
        this.name = name;
        this.price = price;
        this.memberNum = memberNum;
        this.learn_time = learn_time;
        this.orgName = orgName;
        this.create_time = create_time;
    }
}
