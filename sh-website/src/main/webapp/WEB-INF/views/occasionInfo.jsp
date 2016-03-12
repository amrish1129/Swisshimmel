<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>


<table BORDER=1 >
    <c:if test="${!empty occasion.occasionName}">
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
                <spring:message text="Occasion Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="occasionName" readonly="${!occaValueDs.occasionValuesEnabled}"/>
            <form:errors path="occasionName" cssClass="error"/>
            
        </td> 
    </tr>
    
    
    <tr>
        <td>
            <form:label path="city">
                <spring:message text="City"/>
            </form:label>
        </td>
        <td>
            <form:input path="city" readonly="${!occaValueDs.occasionValuesEnabled}"/>
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="country">
                <spring:message text="Country"/>
            </form:label>
        </td>
        <td>
            <form:input path="country" readonly="${!occaValueDs.occasionValuesEnabled}"/>
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="wikiLink">
                <spring:message text="Wiki Link" />
            </form:label>
        </td>
        <td>
            <form:input size="50" maxlength="200" path="wikiLink" readonly="${!occaValueDs.occasionValuesEnabled}"/>
        </td>
    </tr>
        <tr>
        <td>
            <form:label path="repeatsEveryYear">
                <spring:message text="Yearly Event"/>
            </form:label>
        </td>
        <td>
        <form:radiobutton path="repeatsEveryYear" value="1" disabled="${!occaValueDs.occasionValuesEnabled}"/>Yes 
        <form:radiobutton path="repeatsEveryYear" value="0" disabled="${!occaValueDs.occasionValuesEnabled}"/>No
        </td>
        
        
        
    </tr>
  
    <tr>
        <td colspan="2">
                <input type="submit"
                    value="<spring:message text="Add Event"/>"  ${!occaValueDs.viewButtonEnabled ? 'disabled="disabled"' : ''}   />
         
        </td>
    </tr>
   
</table> 
<BR>
<BR>



</html>