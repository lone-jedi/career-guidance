package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.ResultFull;
import com.yarkin.careerguidance.entity.Test;

public interface TestRepository {
    Test getTestById(int testId);

    Result getTestResult(int testId, double score);

    ResultFull getTestResult(int testId, int[] answersIds);
}
