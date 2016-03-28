<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Secure Page</title>
    </head>
    <body>
        This is a users-only page..<br />
        <br />
        <form method="post" action="<c:url value="/logout" />" name="logoutForm">
            <a href="javascript:void 0;"
               onclick="document.logoutForm.submit();">Log Out</a>
        </form>
    </body>
</html>
