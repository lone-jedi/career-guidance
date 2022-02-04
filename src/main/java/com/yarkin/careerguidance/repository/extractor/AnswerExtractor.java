package com.yarkin.careerguidance.repository.extractor;

import com.yarkin.careerguidance.entity.Answer;
import com.yarkin.careerguidance.entity.Question;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerExtractor implements ResultSetExtractor<List<Question>> {

    @Override
    public List<Question> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Question> questions = new ArrayList<>();
        int lastQuestion = -1;

        while (resultSet.next()) {
            int questionId = resultSet.getInt("q_id");
            String questionTitle = resultSet.getString("q_title");
            Question question = new Question(questionId, questionTitle, new ArrayList<>());

            if (!questions.contains(question)) {
                questions.add(question);
                lastQuestion++;
            }

            int answerId = resultSet.getInt("a_id");
            String answerTitle = resultSet.getString("a_title");
            double answerWeight = resultSet.getDouble("weight");
            Answer answer = new Answer(answerId, answerTitle, answerWeight);

            questions.get(lastQuestion).getAnswers().add(answer);
        }

        return questions;
    }
}
