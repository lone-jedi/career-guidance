package com.yarkin.careerguidance.service;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.Test;

public interface TestService {
    Test getMainTest();

    Result getMainTestResult(double score);
}
