package com.sample.blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    PostService blogService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<BlogPost> allPosts = blogService.getAllPosts();
        req.setAttribute("posts", allPosts);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/blog-posts.jsp");
        dispatcher.forward(req, res);
    }
}
