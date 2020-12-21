<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/bootstrap.min.js"></script>
        <style>
            .blog-card {
                height: 150px;
                margin-bottom: 30px;
                padding: 12px;
                border-radius: 5px;
                box-shadow: 3px 3px 5px 6px #ccc;
            }

            a { cursor: pointer; }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row" style="height:200px">
                <h2>MyBlog</h2>
            </div>
            <form action ="jsp/post-form.jsp">
                <button type="submit" class="btn btn-primary btn-md">New Post</button>
                <br></br>
            </form>
            <c:choose>
                <c:when test="${not empty posts}">
                    <c:forEach var="post" items="${posts}">
                        <div class="row blog-card">
                            <h3>${post.title}</h3>
                            <p>${post.content}</p>
                            <a href="/blog?postId=${post.id}&getType=getById">Edit Post</a> | <a>Delete Post</a>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <br>
                    <div class="alert alert-info">
                        No Posts Found
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>