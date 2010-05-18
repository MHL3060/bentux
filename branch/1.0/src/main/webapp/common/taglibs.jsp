<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springmodules.org/tags/commons-validator" prefix="v" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'  %>
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://www.appfuse.org/tags/spring" prefix="appfuse" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>

<c:set var="pleaseSelect">
	<option value=""><fmt:message key="please.select" /></option>
</c:set>

<c:set var="buttons" >
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty id}">
        <input type="submit" class="button" name="delete" onclick="return confirmDelete('')" 
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>"/>
    </li>
</c:set>