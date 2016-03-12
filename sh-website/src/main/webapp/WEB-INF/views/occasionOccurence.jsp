<table>

<c:if test="${!empty occasionTimesList}">
    <table class="tg">
    <tr>
        <th width="80">Event ID</th>
         <th width="80">To Date</th>
        <th width="120">From Date</th>
        <th width="120">Comment</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>1
    
    
  <c:forEach items="${occasionTimesList}" var="occasionTime">
        <tr>
            <td>${occasionTime.occasion_time_id}</td>
            <td>  <form:input path="occasionTime.dateFromStr"  size="11"  id="datepicker-13" /> </td>
            <td>  <form:input path="occasionTime.dateToStr"  size="11"  id="datepicker-13" /> </td>
            <td>  <form:input path="occasionTime.comment"  size="11"  /> </td>
            <td>Edit</a></td>
            <td>Delete</a></td>
        </tr>
    </c:forEach>
</c:if>


</table>