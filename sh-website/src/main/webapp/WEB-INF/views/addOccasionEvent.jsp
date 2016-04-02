<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>View Occasion Detail</title>
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
      
      <style>
    .datepicker{
     
    }
  </style>
 
  <script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
  </script>      
      

     
</head>
<body>
<h1> Occasion Details</h1>
 
<c:url var="addOccasion" value="/occasion/add" ></c:url>
 
<form:form action="${addEvent}" commandName="occasion">
<div class="container">
  
<jsp:include page="occasionInfo.jsp"/>
		
<table>

<c:if test="${!empty occasion.occasionTimes}">
    <table class="tg">
    <tr>
         <th width="80">From Date</th>
        <th width="120">To Date</th>
        <th width="120">Comment</th>
        <th width="60" >Wiki</th>
        <th width="60" colspan = "2" ></th>
    </tr>
    
  <c:forEach items="${occasion.occasionTimes}" var="occasionTime" varStatus="status">
        <tr>
            <td>  
         
           <input type="hidden"   name="occasionTimes[${status.index}].occasion_time_id" value="${occasion.occasionTimes[status.index].occasion_time_id}" />
           <input type="hidden"   name="occasionTimes[${status.index}].occasion_id" value="${occasion.occasionTimes[status.index].occasion_id}" />
           
        
            <form:input path="occasionTimes[${status.index}].dateFromStr"  value="${occasionTime.dateFromStr}" size="11"  class="datepicker" />
            <form:errors path="occasionTimes[${status.index}].dateFromStr" cssClass="error"/>
            	
             </td>
            <td>  <form:input path="occasionTimes[${status.index}].dateToStr"  value="${occasionTime.dateToStr}" size="11"  class="datepicker" /> </td>
            <td>  <form:input path="occasionTimes[${status.index}].comment"  value="${occasionTime.comment}"  size="11"  /> </td>
            <td>  <form:input path="occasionTimes[${status.index}].wiki"  value="${occasionTime.wiki}"  size="11"  /> </td>
            <td>
            
             <input type="image" src="/swisshimmel/img/save_button.png"  WIDTH="20"  HEIGHT="20" name="action" 
            value="saveEvent${occasion.occasionTimes[status.index].occasion_time_id}#${status.index}" ALT="">	
            
            <input type="image" src="/swisshimmel/img/delete_button.png"  WIDTH="20"  HEIGHT="20" name="action" 
            value="delete${occasion.occasionTimes[status.index].occasion_time_id}#${status.index}" ALT="">
           					 
            </td>
            

        </tr>
       
        
    </c:forEach>
</c:if>

</table>

<br>
<br>
  <input type="submit" name="action" value="saveEvents" />
  <input type="submit" name="action" value="addRow" />
<br>
<br>

</div> 
</form:form>
</body>
</html>