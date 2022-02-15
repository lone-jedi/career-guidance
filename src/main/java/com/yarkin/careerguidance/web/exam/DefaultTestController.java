package com.yarkin.careerguidance.web.exam;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.service.TestService;
import com.yarkin.careerguidance.web.TestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/tests")
@RequiredArgsConstructor
public class DefaultTestController implements TestController {
    private final TestService testService;

    @Override
    @GetMapping("/main")
    public Test getMainTest() {
        return testService.getMainTest();
    }

    @Override
    @GetMapping("/main/result/{score}")
    public Result getMainTestResult(@PathVariable double score) {
        return testService.getMainTestResult(score);
    }
}
