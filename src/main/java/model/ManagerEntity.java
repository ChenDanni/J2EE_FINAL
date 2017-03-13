package model;

import javax.persistence.*;

/**
 * Created by cdn on 17/3/9.
 */
@Entity
@Table(name = "manager", schema = "j2ee_final", catalog = "")
public class ManagerEntity {
    private int id;
    private String login;
    private String password;
    private int recharge;
    private int memberHandle;
    private int orgHandle;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 32)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    @Column(name = "recharge", nullable = false)
    public int getRecharge() {
        return recharge;
    }

    public void setRecharge(int recharge) {
        this.recharge = recharge;
    }


    @Basic
    @Column(name = "member_handle", nullable = false)
    public int getMemberHandle() {
        return memberHandle;
    }

    public void setMemberHandle(int memberHandle) {
        this.memberHandle = memberHandle;
    }

    @Basic
    @Column(name = "org_handle", nullable = false)
    public int getOrgHandle() {
        return orgHandle;
    }

    public void setOrgHandle(int orgHandle) {
        this.orgHandle = orgHandle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (recharge != that.recharge) return false;
        if (memberHandle != that.memberHandle) return false;
        if (orgHandle != that.orgHandle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + recharge;
        result = 31 * result + memberHandle;
        result = 31 * result + orgHandle;

        return result;
    }
}
