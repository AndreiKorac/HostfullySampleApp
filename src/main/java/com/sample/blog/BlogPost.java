package com.sample.blog;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class BlogPost {
    private long id;
    private String title;
    private String content;
    private String author;
    private Date postedDate;

    private static final AtomicLong counter = new AtomicLong(100);

    public BlogPost(String title, String content, String author) {
        this.id = counter.incrementAndGet();
        this.title = title;
        this.content = content;
        this.author = author;
        this.postedDate = new Date();
    }

    public long getId() {
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
