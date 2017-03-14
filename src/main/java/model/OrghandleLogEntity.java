package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/13.
 */
@Entity
@Table(name = "orghandle_log", schema = "j2ee_final", catalog = "")
public class OrghandleLogEntity {
    private int id;
    private Integer money;
    private Timestamp time;
    private ClassEntity classId;
    private OrganizationEntity orgId;
    private int orghandle;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "money", nullable = true)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrghandleLogEntity that = (OrghandleLogEntity) o;

        if (id != that.id) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public ClassEntity getClassId() {
        return classId;
    }

    public void setClassId(ClassEntity classId) {
        this.classId = classId;
    }

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    public OrganizationEntity getOrgId() {
        return orgId;
    }

    public void setOrgId(OrganizationEntity orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "orghandle", nullable = false)
    public int getOrghandle() {
        return orghandle;
    }

    public void setOrghandle(int orghandle) {
        this.orghandle = orghandle;
    }
}
