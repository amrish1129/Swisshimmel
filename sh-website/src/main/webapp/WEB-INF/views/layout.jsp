<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="2" align="center">
    <tr>
        <td height="50" colspan="2">
		<jsp:include page="header.jsp"/>
        </td>
    </tr>
    <tr>
        <td height="250" width="80"><jsp:include page="menu.jsp"/></td>
        <td height="250 "width="1000"><jsp:include page="${body}"/></td>
    </tr>
    <tr>
        <td height="50" colspan="2"><jsp:include page="footer.jsp"/> 
        </td>
    </tr>
</table>
</body>
</html>