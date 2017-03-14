package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
@Entity
@Table(name = "class", schema = "j2ee_final", catalog = "")
public class ClassEntity {
    private int id;
    private String name;
    private Date time;
    private String teacher;
    private int price;
    private int memberNum;
    private int state;
    private String description;
    private String learnTime;
    private int leftMembers;
    private OrganizationEntity orgId;
    private Collection<LessonEntity> lessones;
    private Collection<ChargeLogEntity> chargeLogs;
    private Collection<MemberhandleLogEntity> memberhandleLog;
    private Collection<OrghandleLogEntity> orghandleLog;
    private List<OrgLogEntity> orgLog;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 11)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "teacher", nullable = false, length = 32)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "member_num", nullable = false)
    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "learn_time", nullable = false, length = 64)
    public String getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(String learnTime) {
        this.learnTime = learnTime;
    }

    @Basic
    @Column(name = "left_members", nullable = false)
    public int getLeftMembers() {
        return leftMembers;
    }

    public void setLeftMembers(int leftMembers) {
        this.leftMembers = leftMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassEntity that = (ClassEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (memberNum != that.memberNum) return false;
        if (state != that.state) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (learnTime != null ? !learnTime.equals(that.learnTime) : that.learnTime != null) return false;
        if (leftMembers != that.leftMembers) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + memberNum;
        result = 31 * result + state;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (learnTime != null ? learnTime.hashCode() : 0);
        result = 31 * result + leftMembers;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    public OrganizationEntity getOrgId() {
        return orgId;
    }

    public void setOrgId(OrganizationEntity orgId) {
        this.orgId = orgId;
    }

    @OneToMany(mappedBy = "classId")
    public Collection<LessonEntity> getLessones() {
        return lessones;
    }

    public void setLessones(Collection<LessonEntity> lessones) {
        this.lessones = lessones;
    }

    @OneToMany(mappedBy = "classId")
    public Collection<ChargeLogEntity> getChargeLogs() {
        return chargeLogs;
    }

    public void setChargeLogs(Collection<ChargeLogEntity> chargeLogs) {
        this.chargeLogs = chargeLogs;
    }

    @OneToMany(mappedBy = "classId")
    public Collection<MemberhandleLogEntity> getMemberhandleLog() {
        return memberhandleLog;
    }

    public void setMemberhandleLog(Collection<MemberhandleLogEntity> memberhandleLog) {
        this.memberhandleLog = memberhandleLog;
    }

    @OneToMany(mappedBy = "classId")
    public Collection<OrghandleLogEntity> getOrghandleLog() {
        return orghandleLog;
    }

    public void setOrghandleLog(Collection<OrghandleLogEntity> orghandleLog) {
        this.orghandleLog = orghandleLog;
    }

    @OneToMany(mappedBy = "classId")
    public List<OrgLogEntity> getOrgLog() {
        return orgLog;
    }

    public void setOrgLog(List<OrgLogEntity> orgLog) {
        this.orgLog = orgLog;
    }
}
