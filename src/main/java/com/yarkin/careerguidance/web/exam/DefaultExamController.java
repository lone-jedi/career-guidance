package com.yarkin.careerguidance.web.exam;

import com.yarkin.careerguidance.entity.exam.Exam;
import com.yarkin.careerguidance.service.ExamService;
import com.yarkin.careerguidance.web.ExamController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/exams")
@RequiredArgsConstructor
public class DefaultExamController implements ExamController {

    private final ExamService examService;

    @Override
    @GetMapping
    public List<Exam> findAll() {
        return examService.findAll();
    }

}