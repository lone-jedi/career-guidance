package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.exam.Exam;
import java.util.List;

public interface ExamRepository {
    List<Exam> findAll();
}
