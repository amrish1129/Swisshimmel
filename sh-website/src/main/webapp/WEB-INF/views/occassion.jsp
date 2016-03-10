<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Enter an occassion</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add occassion
</h1>
 
<c:url var="addOccasion" value="/occasion/add" ></c:url>
 
<form:form action="${addOccasion}" commandName="occasion">
<table>
    <c:if test="${!empty person.name}">
    <tr>
        <td>
            <form:label path="occasion_id">
                <spring:message text="Occasion Id"/>
            </form:label>
        </td>
        <td>
            <form:input path="occasion_id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="occasion_id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="occasionName">
                <spring:message text="occasionName"/>
            </form:label>
        </td>
        <td>
            <form:input path="occasionName" />
        </td> 
    </tr>
    
    
    <tr>
        <td>
            <form:label path="city">
                <spring:message text="city"/>
            </form:label>
        </td>
        <td>
            <form:input path="city" />
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="country">
                <spring:message text="Country"/>
            </form:label>
        </td>
        <td>
            <form:input path="country" />
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="wikiLink">
                <spring:message text="wikiLink"/>
            </form:label>
        </td>
        <td>
            <form:input path="wikiLink" />
        </td>
    </tr>
    
    
        <tr>
        <td>
            <form:label path="repeatsEveryYear">
                <spring:message text="repeatsEveryYear"/>
            </form:label>
        </td>
        <td>
        <form:radiobutton path="repeatsEveryYear" value="1"/> Yes 
        <form:radiobutton path="repeatsEveryYear" value="0"/>No
        </td>
    </tr>
    
    
    <tr>
        <td colspan="2">
                <input type="submit"
                    value="<spring:message text="Add Occasion"/>" />
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Occasion List</h3>
<c:if test="${!empty listOccassion}">
    <table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person Name</th>
        <th width="120">Person Country</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listOccassion}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.country}</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>