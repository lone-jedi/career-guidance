package com.yarkin.careerguidance.service.exam;

import com.yarkin.careerguidance.entity.exam.Exam;
import com.yarkin.careerguidance.repository.ExamRepository;
import com.yarkin.careerguidance.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultExamService implements ExamService {
    private final ExamRepository examRepository;

    public List<Exam> findAll() {
        return examRepository.findAll();
    }
}
