package com.yarkin.careerguidance.repository;

import com.yarkin.careerguidance.entity.Test;

public interface TestRepository {
    Test getTestById(int testId);
}
