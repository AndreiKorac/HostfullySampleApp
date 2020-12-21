package com.sample.blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "BlogServlet",
        urlPatterns = { "/blog" }
)
public class BlogServlet extends HttpServlet {
    // In reality an instance of this would probably be provided in the constructor via dependency injection
    // At least it would in .NET Core and I'm assuming Spring has some equivalent
    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String getType = req.getParameter("getType");

        if (getType != null && getType.equals("getById")) {
            getPostById(req, res);
        } else {
            ArrayList<BlogPost> allPosts = postService.getAllPosts();
            forwardGetAllPosts(req, res, allPosts);
        }
    }

    private void forwardGetAllPosts(HttpServletRequest req, HttpServletResponse res, ArrayList<BlogPost> posts) throws ServletException, IOException {
        req.setAttribute("posts", posts);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/blog-posts.jsp");
        dispatcher.forward(req, res);
    }

    private void getPostById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = Integer.valueOf(req.getParameter("postId"));
        BlogPost post = null;
        try {
            post = postService.getPostById(id);
        } catch(Exception e) {
            Logger.getLogger(BlogPost.class.getName()).log(Level.SEVERE, null, e);
        }
        req.setAttribute("post", post);
        req.setAttribute("action", "edit");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/post-form.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addPost(req, res);
                break;
            case "edit":
                editPost(req, res);
                break;
        }
    }

    private void addPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        long createdId = postService.addPost(title, content);

        req.setAttribute("createdId", createdId);
        String result = "Post successfully created.";
        req.setAttribute("resultMessage", result);

        ArrayList<BlogPost> newPostsList = postService.getAllPosts();
        forwardGetAllPosts(req, res, newPostsList);
    }

    private void editPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = Integer.valueOf(req.getParameter("content"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean success = postService.updatePost(id, title, content);
        String result = null;
        if (success) {
            result = req.getParameter("content");
        }
        ArrayList<BlogPost> newPostsList = postService.getAllPosts();
        forwardGetAllPosts(req, res, newPostsList);
    }
}
