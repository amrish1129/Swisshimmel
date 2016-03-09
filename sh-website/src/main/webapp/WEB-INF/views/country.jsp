<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Property Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    <style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
<h1>
    Add a Country
</h1>
 
<c:url var="addConurty" value="/country/add" ></c:url>
 
<form:form action="${addConurty}" commandName="country">


<table>
    <c:if test="${!empty country.countryName}">
    <tr>
        <td>
            <form:label path="countryId">
                <spring:message text="countryId"/>
            </form:label>
        </td>
        <td>
            <form:input path="countryId" readonly="true" size="3"  disabled="true" />
            <form:hidden path="countryId" />
        </td> 
    </tr>
    </c:if>
    
    <tr>
        <td>
            <form:label path="countryName">
                <spring:message text="Country Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="countryName" size="20"/>
            <form:errors path="countryName" cssClass="error"/>
        </td> 
    </tr>
    
    <tr>
    
        <td>
            <form:label path="currency">
                <spring:message text="Currency"/>
            </form:label>
        </td>
        <td>
            <form:input path="currency" />
        </td> 
    </tr>
    
    <tr>
        <td>
            <form:label path="shortCountryCode">
                <spring:message text="Country Short Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="shortCountryCode" />
            <form:errors path="shortCountryCode" cssClass="error"/>
            
        </td> 
    </tr>
	 
	  
	</div>
       

   
    <tr>
        <td colspan="2">
            <c:if test="${!empty country.countryName}">
                <input type="submit"
                    value="<spring:message text="Edit Property"/>" />
            </c:if>
            <c:if test="${empty country.countryName}">
                <input type="submit"
                    value="<spring:message text="Add Property"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Property List</h3>
<c:if test="${!empty listCountry}">
    <table class="tg">
    <tr>
        <th width="80">Country ID</th>
         <th width="80">Country Name</th>
        <th width="120">currency</th>
        <th width="120">shortCountryCode</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listCountry}" var="country">
        <tr>
            <td>${country.countryId}</td>
             <td>${country.countryName}</td>
            <td>${country.currency}</td>
            <td>${country.shortCountryCode}</td>
          
            
            <td><a href="<c:url value='/editCountry/${country.countryId}' />" >Edit</a></td>
            <td><a href="<c:url value='/removeCountry/${country.countryId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>