package com.mrhmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List index() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{domain}/{path}")
    public List getComments(@PathVariable String domain, @PathVariable String path) {
        return commentRepository.findByDomainAndPath(domain, path);
    }

    @PostMapping("/comments")
    public Comment create(@RequestBody Map<String, String> body){
        String domain = body.get("domain");
        String path = body.get("path");
        String content = body.get("content");
        String name = body.get("name");
        String email = body.get("email");

        return commentRepository.save(new Comment(domain, path, content, name, email));
    }
}