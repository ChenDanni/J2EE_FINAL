package model;

import javax.persistence.*;

/**
 * Created by cdn on 17/3/11.
 */
@Entity
@Table(name = "lesson_member", schema = "j2ee_final", catalog = "")
@IdClass(LessonMemberEntityPK.class)
public class LessonMemberEntity {
    private int lessonId;
    private int cardId;
    private int records;
    private Integer attendence;

    @Id
    @Column(name = "lesson_id", nullable = false)
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Id
    @Column(name = "card_id", nullable = false)
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "records", nullable = false)
    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    @Basic
    @Column(name = "attendence", nullable = true)
    public Integer getAttendence() {
        return attendence;
    }

    public void setAttendence(Integer attendence) {
        this.attendence = attendence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonMemberEntity that = (LessonMemberEntity) o;

        if (lessonId != that.lessonId) return false;
        if (cardId != that.cardId) return false;
        if (records != that.records) return false;
        if (attendence != null ? !attendence.equals(that.attendence) : that.attendence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lessonId;
        result = 31 * result + cardId;
        result = 31 * result + records;
        result = 31 * result + (attendence != null ? attendence.hashCode() : 0);
        return result;
    }
}
