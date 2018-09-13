package com.mrhmt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String domain;
    private String path;
    private String content;
    private String name;
    private String email;

    public Comment() {
    }

    public Comment(String domain, String path, String content, String name, String email) {
        this.domain = domain;
        this.path = path;
        this.content = content;
        this.name = name;
        this.email = email;
    }

    public Comment(int id, String domain, String path, String content, String name, String email) {
        this.id = id;
        this.domain = domain;
        this.path = path;
        this.content = content;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
