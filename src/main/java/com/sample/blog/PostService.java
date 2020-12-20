package com.sample.blog;

import java.util.ArrayList;

public class PostService {
    // In reality this would likely be a repository/data access layer reference to the database table
    ArrayList<BlogPost> blogPosts = Posts.getData();

    public ArrayList<BlogPost> getAllPosts() {
        return blogPosts;
    }
}
