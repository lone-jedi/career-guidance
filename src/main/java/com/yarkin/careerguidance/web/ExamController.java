package com.yarkin.careerguidance.web;

import com.yarkin.careerguidance.entity.exam.Exam;
import java.util.List;

public interface ExamController {
    List<Exam> findAll();
}
