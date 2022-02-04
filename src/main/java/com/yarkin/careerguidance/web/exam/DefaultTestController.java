package com.yarkin.careerguidance.web.exam;

import com.yarkin.careerguidance.entity.Question;
import com.yarkin.careerguidance.entity.Test;
import com.yarkin.careerguidance.service.ExamService;
import com.yarkin.careerguidance.service.TestService;
import com.yarkin.careerguidance.web.TestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
