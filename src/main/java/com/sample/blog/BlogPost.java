package com.sample.blog;

import java.util.Date;
import java.util.UUID;

public class BlogPost {
    private UUID id;
    private String title;
    private String content;
    private String author;
    private Date postedDate;

    public BlogPost(String title, String content, String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.author = author;
        this.postedDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPostedDate() {
        return postedDate;
    }
}
