package com.yarkin.careerguidance.web;

import com.yarkin.careerguidance.entity.exam.Exam;
import com.yarkin.careerguidance.service.ExamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(ExamController.class)
class ExamControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    @Test
    public void testFindAll() throws Exception {
        Mockito.when(examService.findAll()).thenReturn(List.of(
                new Exam(1, "Математика"),
                new Exam(2, "Література")
        ));

        mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/exams")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Математика"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Література"));

        verify(examService, times(1)).findAll();
    }


}