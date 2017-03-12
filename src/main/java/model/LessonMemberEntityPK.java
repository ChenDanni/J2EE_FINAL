package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cdn on 17/3/11.
 */
public class LessonMemberEntityPK implements Serializable {
    private int lessonId;
    private int cardId;

    @Column(name = "lesson_id", nullable = false)
    @Id
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Column(name = "card_id", nullable = false)
    @Id
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonMemberEntityPK that = (LessonMemberEntityPK) o;

        if (lessonId != that.lessonId) return false;
        if (cardId != that.cardId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lessonId;
        result = 31 * result + cardId;
        return result;
    }
}
