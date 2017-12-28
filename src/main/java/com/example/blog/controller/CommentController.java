package com.example.blog.controller;

import com.example.blog.dto.CommentDTO;
import com.example.blog.dto.NewCommentDTO;
import com.example.blog.dto.UpdateCommentDTO;
import com.example.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@Api(description = "Операції повязані з коментарями до постів")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @ApiOperation(value = "Додавання нового коментаря")
    public void createComment(@RequestBody NewCommentDTO comment) {
        commentService.createComment(comment);
    }

    @GetMapping
    @ApiOperation(value = "Отримання всіх коментарів, сортованих по даті публікації")
    public List<CommentDTO> readComments() {
        return commentService.readComments();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Отримання коментаря по ID")
    public CommentDTO readComment(@PathVariable int id) {
        return commentService.readComment(id);
    }

    @GetMapping(value = "post/{id}")
    @ApiOperation(value = "Отримання всіх коментарів, для конкретного поста, ID поста задається")
    public List<CommentDTO> readCommentsByPostId(@PathVariable int id) {
        return commentService.readCommentsByPostId(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Оновлення коментаря по ID")
    public int updateComment(@RequestBody UpdateCommentDTO comment, @PathVariable int id) {
        return commentService.updateComment(comment, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Видалення всіх коментарів")
    public void deleteComments() {
        commentService.deleteComments();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Видалення коментаря по ID")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }

}
