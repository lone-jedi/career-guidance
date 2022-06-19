package com.yarkin.careerguidance.repository.extractor;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.ResultFull;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: add class / interface description
 *
 * @author OYarkin
 * @since 8.3.0
 */
public class ResultExtractor implements ResultSetExtractor<ResultFull>
{
    @Override
    public ResultFull extractData(ResultSet resultSet) throws SQLException, DataAccessException
    {
        List<Result> results = new ArrayList<>();

        while(resultSet.next()) {
            int resultId = resultSet.getInt("result_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            int answersCount = resultSet.getInt("answers_count");
            results.add(new Result(resultId, title, description, answersCount, -1, 1, null));
        }

        ResultFull resultFull = new ResultFull(
            results.get(0).getResultId(), results.get(0).getTitle(), results.get(0).getDescription());
        resultFull.setResults(results);

        return resultFull;
    }
}
