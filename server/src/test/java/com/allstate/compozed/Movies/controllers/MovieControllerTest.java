package com.allstate.compozed.Movies.controllers;

import com.allstate.compozed.Movies.AppRepository;
import com.allstate.compozed.Movies.models.MovieModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppRepository repository;

    @Test
    public void createAppDelegatesToRepository() throws Exception {
        when(repository.save(any(MovieModel.class))).then(returnsFirstArg());

        final MockHttpServletRequestBuilder post = post("/api/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Yogi Bear\"}");

        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.name", is("Triangle")))
//                .andExpect(jsonPath("$.memoryAllocationMb", is(128)))
//                .andExpect(jsonPath("$.diskAllocationMb", is(128)))
//                .andExpect(jsonPath("$.spaceId", is(1)));

        verify(repository).save(any(MovieModel.class));
    }
}