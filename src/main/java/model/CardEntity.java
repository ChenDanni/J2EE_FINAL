package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
@Entity
@Table(name = "card", schema = "j2ee_final", catalog = "")
public class CardEntity {
    private int id;
    private int balance;
    private String accountId;
    private int state;
    private int level;
    private String password;
    private String name;
    private String phone;
    private int consume;
    private int points;
    private Collection<ChargeLogEntity> chargeLogs;
    private Collection<MemberhandleLogEntity> memberhandleLog;
    private Collection<RechargeLogEntity> rechargeLog;
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
    @Column(name = "balance", nullable = true)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "account_id", nullable = true)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
    @Column(name = "level", nullable = true)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "phone", nullable = false, length = 14)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "consume", nullable = true)
    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    @Basic
    @Column(name = "points", nullable = true)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (balance != that.balance) return false;
        if (level != that.level) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (consume != that.consume) return false;
        if (points != that.points) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + balance;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + level;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + consume;
        result = 31 * result + points;
        return result;
    }

    @OneToMany(mappedBy = "cardId")
    public Collection<ChargeLogEntity> getChargeLogs() {
        return chargeLogs;
    }

    public void setChargeLogs(Collection<ChargeLogEntity> chargeLogs) {
        this.chargeLogs = chargeLogs;
    }

    @OneToMany(mappedBy = "cardId")
    public Collection<MemberhandleLogEntity> getMemberhandleLog() {
        return memberhandleLog;
    }

    public void setMemberhandleLog(Collection<MemberhandleLogEntity> memberhandleLog) {
        this.memberhandleLog = memberhandleLog;
    }

    @OneToMany(mappedBy = "cardId")
    public Collection<RechargeLogEntity> getRechargeLog() {
        return rechargeLog;
    }

    public void setRechargeLog(Collection<RechargeLogEntity> rechargeLog) {
        this.rechargeLog = rechargeLog;
    }

    @OneToMany(mappedBy = "cardId")
    public List<OrgLogEntity> getOrgLog() {
        return orgLog;
    }

    public void setOrgLog(List<OrgLogEntity> orgLog) {
        this.orgLog = orgLog;
    }
}
