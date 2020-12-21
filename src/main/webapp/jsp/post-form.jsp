<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form action="/blog" method="post" role="form" data-toggle="validator" >
                <c:if test ="${empty action}">
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="postId" name="postId" value="${post.id}">
                <h2>Post</h2>
                <div class="form-group col-xs-4">
                    <label for="title" class="control-label col-xs-4">Title:</label>
                    <input type="text" name="title" id="title" class="form-control" value="${post.title}" required="true" />

                    <label for="content" class="control-label col-xs-4">Content</label>
                    <textarea rows="4" cols="50" name="content" id="content" class="form-control" required="true">
                        <c:out value="${post.content}" />
                    </textarea>

                    <br />
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button>
                </div>
            </form>
        </div>
    </body>
</html>