package com.guanyu.app.web.controller;

import com.guanyu.app.model.dto.CommentDTO;
import com.guanyu.app.model.dto.base.PageInfo;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.CommentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommentControllerTest {

    @Resource
    private CommentController controller;

    @MockBean
    private CommentService commentService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getComments() {

        long page = 1;
        long size = 5;
        Mockito.when(commentService.getComments(page, size))
                .thenReturn(PageInfo.of(page, 10, Collections.singletonList(new CommentDTO())));

        Result<PageInfo<CommentDTO>> result = controller.getComments(page, size);
        assertEquals(result.getCode(), 0);
        assertNotNull(result.getData());
        List<CommentDTO> comments = result.getData().getData();
        assertEquals(comments.size(), 5);
    }

    @Test
    void commentable() {
    }

    @Test
    void createComment() {
    }

    @Test
    void deleteComment() {
    }
}