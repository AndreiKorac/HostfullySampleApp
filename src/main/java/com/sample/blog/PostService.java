package com.sample.blog;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class PostService {
    // In reality this would likely be a repository/data access layer reference to the database table
    private ArrayList<BlogPost> blogPosts = Posts.getData();

    public ArrayList<BlogPost> getAllPosts() {
        return blogPosts;
    }

    public BlogPost getPostById(long id) throws Exception {
        Optional<BlogPost> post = blogPosts.stream().filter(p -> p.getId() == id).findFirst();
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new Exception("Could not find Post for Id" + id);
        }
    }

    public long addPost(String title, String content) {
        BlogPost post = new BlogPost(title, content, "Andrei");
        blogPosts.add(post);
        return post.getId();
    }

    public boolean updatePost(long id, String title, String content) {
        Optional<BlogPost> post = blogPosts.stream().filter(p -> p.getId() == id).findFirst();
        if (post.isPresent()) {
            BlogPost postToUpdate = post.get();
            postToUpdate.setTitle(title);
            postToUpdate.setContent(content);
            return true;
        } else {
            return false;
        }
    }
}
