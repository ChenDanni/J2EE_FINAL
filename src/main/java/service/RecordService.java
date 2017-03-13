package service;

/**
 * Created by cdn on 17/3/13.
 */
public interface RecordService {

    public boolean setAttend(int cardId, int lessonId);

    public boolean setAbsence(int cardId, int lessonId);

    public boolean setScore(int score, int cardId, int classId);

}
