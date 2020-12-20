package com.sample.blog;

import java.util.ArrayList;

public class Posts {
    private static final ArrayList<BlogPost> posts = new ArrayList();

    private Posts() { }

    static {
        posts.add(new BlogPost("Hello World!", "Welcome to my blog, this is my first post!", "Andrei"));
        posts.add(new BlogPost("Covid", "2020 has been pretty lame because of covid eh.", "Andrei"));
    }

    public static ArrayList<BlogPost> getData() {
        return posts;
    }
}
