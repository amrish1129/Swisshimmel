<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Property Page</title>
    
   
<style>
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
   </style>
   
   <style>
   .error {
        color: blue; font-weight: bold;
    }
   
     </style>
  
   
</head>
<body>
<h1>
    Add a Property
</h1>
 
<c:url var="addAction" value="/property/add" ></c:url>
 
<form:form action="${addAction}" commandName="property">


<table>
    <c:if test="${!empty property.propertyName}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="propertyName">
                <spring:message text="propertyName"/>
            </form:label>
        </td>
        <td>
            <form:input path="propertyName" />
        </td> 
    </tr>
    
    <tr>
        <td>
            <form:label path="propId">
                <spring:message text="propId"/>
            </form:label>
        </td>
        <td>
            <form:input path="propId" />
            <form:errors path="propId" cssClass="error"/>
            
        </td> 
    </tr>
    
    <tr>
        <td>
            <form:label path="location">
                <spring:message text="Location"/>
            </form:label>
        </td>
        <td>
            <form:input path="location" />
        </td> 
    </tr>
    
     <tr>
        <td>
            <form:label path="phoneNumber">
                <spring:message text="phoneNumber"/>
            </form:label>
        </td>
        <td>
            <form:input path="phoneNumber" />
            <form:errors path="phoneNumber" cssClass="error"/>
            
        </td> 
       
    </tr>
    
    <tr>
        <td>
            <form:label path="city">
                <spring:message text="City"/>
            </form:label>
        </td>
        <td>
            <form:input path="city" />
            <form:errors path="city" cssClass="error"/>
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
            <form:errors path="country" cssClass="error"/>
        </td>
	 </tr>
	 
	 
	     <tr>
        <td>
            <form:label path="nearestAirport">
                <spring:message text="Closest Airport"/>
            </form:label>
        </td>
        <td>
            <form:input path="nearestAirport" />
        </td>
	 </tr>
	 
	 
	  <tr>
        <td>
            <form:label path="nearestStation">
                <spring:message text="Closest Station"/>
            </form:label>
        </td>
        <td>
            <form:input path="nearestStation" />
        </td>
	 </tr>

  <tr>
        <td>
            <form:label path="howToReachAirport">
                <spring:message text="Airport Direction"/>
            </form:label>
        </td>
        <td>
            <form:input path="howToReachAirport" />
        </td>
	 </tr>
	   <tr>
        <td>
            <form:label path="howToReachStation">
                <spring:message text="Station Direction"/>
            </form:label>
        </td>
        <td>
            <form:input path="howToReachStation" />
        </td>
	 </tr>
	   <tr>
        <td>
            <form:label path="email">
                <spring:message text="email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
            <form:errors path="email"  cssClass="error"/>
            
             </td>
	 </tr>
	</div>
       

   
    <tr>
        <td colspan="2">
            <c:if test="${!empty property.propertyName}">
                <input type="submit"
                    value="<spring:message text="Edit Property"/>" />
            </c:if>
            <c:if test="${empty property.propertyName}">
                <input type="submit"
                    value="<spring:message text="Add Property"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Property List</h3>
<c:if test="${!empty listProperty}">
    <table class="tg">
    <tr>
        <th width="80">Property ID</th>
        <th width="120">Given ID</th>
        <th width="120">Property Name</th>
        <th width="120">City</th>
        <th width="120">country</th>
        <th width="120">Nearest Airport</th>
        <th width="120">Railway Station</th>
          <th width="120">email</th>
        <th width="120">Phone Number</th>
         <th width="120">Location</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listProperty}" var="property">
        <tr>
            <td>${property.id}</td>
            <td>${property.propId}</td>
            <td>${property.propertyName}</td>
            <td>${property.city}</td>
            <td>${property.country}</td>
            <td>${property.nearestAirport}</td>
            <td>${property.nearestStation}</td>
            <td>${property.email}</td>
            <td>${property.phoneNumber}</td>
            <td>${property.location}</td>
            
            <td><a href="<c:url value='/editProp/${property.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/removeProp/${property.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>