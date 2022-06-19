package com.yarkin.careerguidance.web.test;

import com.yarkin.careerguidance.entity.Result;
import com.yarkin.careerguidance.entity.ResultFull;
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

    @Override
    @PostMapping("/main/result")
    public ResultFull getMainTestResult(@RequestBody int[] answerIds)
    {
        return testService.getMainTestResult(answerIds);
    }
}
