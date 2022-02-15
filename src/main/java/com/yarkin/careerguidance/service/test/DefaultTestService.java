package com.yarkin.careerguidance.service.test;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.repository.TestRepository;
import com.yarkin.careerguidance.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultTestService implements TestService {
    private static final int DEFAULT_MAIN_CAREER_TEST_ID = 1;
    private final TestRepository testRepository;

    /**
     * Obtain from database main career test
     * The main test ID by default equals 1
     *
     * @return Test - main career test object
     */
    @Override
    public Test getMainTest() {
        return testRepository.getTestById(DEFAULT_MAIN_CAREER_TEST_ID);
    }

    @Override
    public Result getMainTestResult(double score) {
        return testRepository.getTestResult(DEFAULT_MAIN_CAREER_TEST_ID, score);
    }
}
