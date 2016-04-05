<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/static/css/style.css" />">
</head>  
<body class="<tiles:getAsString name="body-class"/>">  
        <div><tiles:insertAttribute name="header" /></div>  
        <div style="float:left;padding:0px;width:17%;"><tiles:insertAttribute name="menu" /></div>  
        <div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">  
        	<tiles:insertAttribute name="main1" />
        	<tiles:insertAttribute name="main2" />
        	<tiles:insertAttribute name="main3" />
        	<tiles:insertAttribute name="main4" />
        	<tiles:insertAttribute name="main5" />
        	<tiles:insertAttribute name="main6" />
        	<tiles:insertAttribute name="main7" />
        </div>  
        <div style="clear:both"><tiles:insertAttribute name="footer" /></div>  
  
</body>  
</html> 