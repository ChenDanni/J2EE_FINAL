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
    private int attendance;

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
    @Column(name = "attendance", nullable = true)
    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonMemberEntity that = (LessonMemberEntity) o;

        if (lessonId != that.lessonId) return false;
        if (cardId != that.cardId) return false;
        if (attendance != that.attendance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lessonId;
        result = 31 * result + cardId;
        result = 31 * result + attendance;
        return result;
    }
}
