<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Enter an occassion</title>
      <meta charset="utf-8">
       <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      
      
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    
     
      <script>
      .error {
          color: red; font-weight: bold;
      }
      </script>
      <!-- Javascript -->
  
      <script>
      $(function() {
 	 	$("#occasionName").focus();
	});
      
      </script>
     
</head>
<body>
<h1>
    Add an Event
</h1>
 
<c:url var="addOccasion" value="/occasion/add" ></c:url>
 
<form:form action="${addOccasion}" commandName="occasion">
<div>
  
<jsp:include page="occasionInfo.jsp"/>
		
			
<jsp:include page="occasionResult.jsp"/>

</div> 
</form:form>
</body>
</html>