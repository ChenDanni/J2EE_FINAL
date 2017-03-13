package service;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
public interface LessonService {

    public List<String> getLessonName(List<Integer> lessonIds);

    public String getLessonName(int lessonId);
}
