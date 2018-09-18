package com.mrhmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.mrhmt.model.Comment;
import com.mrhmt.model.CommentRepository;

@CrossOrigin(origins = "https://mrhmt.com", maxAge = 3600)
@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("${APIv1}/comments")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("${APIv1}/comments/{domain}/{path}")
    public List<Comment> getComments(@PathVariable String domain, @PathVariable String path) {
        return commentRepository.findByDomainAndPath(domain, path);
    }

    @PostMapping("${APIv1}/comments")
    public Comment create(@RequestBody Map<String, String> body) {
        String domain = body.get("domain");
        String path = body.get("path");
        String content = body.get("content");
        String name = body.get("name");
        String email = body.get("email");

        return commentRepository.save(new Comment(domain, path, content, name, email));
    }

    @PutMapping("${APIv1}/comments/{id}")
    public Comment update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int commentId = Integer.parseInt(id);
        Comment comment = commentRepository.findOne(commentId);
        if (comment != null) {
            comment.setContent(body.get("content"));

            return commentRepository.save(comment);
        } else {
            return new Comment();
        }

    }

    @DeleteMapping("${APIv1}/comments/{id}")
    public boolean delete(@PathVariable String id) {
        int commentId = Integer.parseInt(id);
        Comment comment = commentRepository.findOne(commentId);
        if (comment == null) {
            return false;
        }

        commentRepository.delete(commentId);

        return true;
    }
}