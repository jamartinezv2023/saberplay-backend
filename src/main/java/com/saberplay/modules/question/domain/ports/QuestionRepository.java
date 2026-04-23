package com.saberplay.modules.question.domain.ports;

import com.saberplay.modules.question.domain.model.Question;
import java.util.List;

public interface QuestionRepository {
    List<Question> findByArea(String area);
    List<Question> findByAreaAndDifficulty(String area, String difficulty);
    void save(Question question);
}
