<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>MyBlog</h2>
            <c:choose>
                <c:when test="${not empty posts}">
                    <c:forEach var="post" items="${posts}">
                        <div>
                            <p>${post.title}</p>
                            <p>${post.content}</p>
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