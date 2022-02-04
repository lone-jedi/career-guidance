package com.yarkin.careerguidance.repository.mapper;

import com.yarkin.careerguidance.entity.Answer;
import com.yarkin.careerguidance.entity.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionFullRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

        int questionId = resultSet.getInt("q_id");
        String questionTitle = resultSet.getString("q_title");

        int answerId = resultSet.getInt("a_id");
        String answerTitle = resultSet.getString("a_title");
        double answerWeight = resultSet.getDouble("weight");

        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(answerId, answerTitle, answerWeight));

        while(resultSet.next()) {
            int nextQuestionId = resultSet.getInt("q_id");
            if(nextQuestionId != questionId) {
                break;
            }

            answerId = resultSet.getInt("a_id");
            answerTitle = resultSet.getString("a_title");
            answerWeight = resultSet.getDouble("weight");

            answers.add(new Answer(answerId, answerTitle, answerWeight));
        }

        return new Question(questionId, questionTitle, answers);
    }
}
