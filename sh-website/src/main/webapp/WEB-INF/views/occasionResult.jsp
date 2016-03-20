<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>

<c:if test="${!empty listOccasion}">
    <table class="tg">
    <tr>
         <th width="80">Occasion Name</th>
        <th width="80">City</th>
        <th width="120">Country</th>
        <th width="120">Comment</th>
        <th width="100">Add Occasion time</th>
        <th width="100">Edit Occasion</th>
    </tr>
    
    
  <c:forEach items="${listOccasion}" var="occasion">
        <tr>
            
            <td>${occasion.occasionName}</td>
            <td>${occasion.city}</td>
            <td>${occasion.country}</td>
            <td>${occasion.comment}</td>
          	<td><a href="<c:url value='/addEventTime/${occasion.occasion_id}' />" >Add Event Time</a></td>
            <td><a href="<c:url value='/editOccasion/${occasion.occasion_id}'/>" >Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>


</html>