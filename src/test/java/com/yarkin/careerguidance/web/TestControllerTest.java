package com.yarkin.careerguidance.web;

import com.yarkin.careerguidance.entity.*;
import com.yarkin.careerguidance.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

    @org.junit.jupiter.api.Test
    public void getMainCareerTest() throws Exception {
        List<Answer> answersFirst = List.of(
                new Answer(1, "A11", -1),
                new Answer(2, "A12", 1),
                new Answer(3, "A13", 0.2)
        );

        List<Answer> answersSecond = List.of(
                new Answer(4, "A21", 0.3),
                new Answer(5, "A22", 1),
                new Answer(6, "A23", 1.2)
        );

        List<Question> questions = List.of(
                new Question(1, "Q1", answersFirst),
                new Question(2, "Q2", answersSecond)
        );

        Test mainTest = new Test(1, "Title", "Description...");
        mainTest.setQuestions(questions);

        when(testService.getMainTest()).thenReturn(mainTest);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/tests/main")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.description").value("Description..."))
                .andExpect(jsonPath("$.questions", hasSize(2)))
                .andExpect(jsonPath("$.questions[0].id").value(1))
                .andExpect(jsonPath("$.questions[0].title").value("Q1"))
                .andExpect(jsonPath("$.questions[0].answers", hasSize(3)))
                .andExpect(jsonPath("$.questions[0].answers[0].id").value(1))
                .andExpect(jsonPath("$.questions[0].answers[0].title").value("A11"))
                .andExpect(jsonPath("$.questions[0].answers[2].weight").value(0.2))
                .andExpect(jsonPath("$.questions[1].answers", hasSize(3)));
    }

    @org.junit.jupiter.api.Test
    public void geMainTestResult() {
        List<Cathedra> onaftCathedraList = List.of(
                new Cathedra(1,"Право", ""),
                new Cathedra(2,"Комп техн", ""),
                new Cathedra(3,"Хор :))", "")
        );

        List<Cathedra> onuCathedraList = List.of(
                new Cathedra(4,"Народний хор :))", ""),
                new Cathedra(5,"Скульптурологія", "")
        );

        List<University> musicUniversities = List.of(
                new University(1, "Мечникова", "", 4342, "", "Ukraine, Odessa", onuCathedraList),
                new University(1, "ОНАХТ", "", 4342, "", "Ukraine, Odessa", onaftCathedraList)
        );

        List<University> artUniversities = List.of(
            new University(1, "Мечникова", "", 4342, "", "Ukraine, Odessa", onuCathedraList)
        );

        List<Specialty> specialties = List.of(
            new Specialty(1, "Музика", "", musicUniversities),
            new Specialty(2, "Мистецтво", "", artUniversities)
        );

        Result expected = new Result(1, "Гуманітарій", "Круто!", 10, 19, specialties);

        // TODO finish geMainTestResult test: create asserts!
    }

}
