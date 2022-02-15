package com.yarkin.careerguidance.web;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.Test;

import java.util.List;

public interface TestController {
    Test getMainTest();

    Result getMainTestResult(double score);
}
