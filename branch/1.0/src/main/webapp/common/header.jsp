<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
<script type="text/javascript"  src="<c:url value="/scripts/ruzee.js" />" ></script>
<script type="text/javascript" src="<c:url value="/scripts/image_rotator.js" />" ></script>
<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor_basic.js" />" ></script>

<div id="branding">

    <h1><img src="<c:url value="/images/logo_small.png"/>" height="100" style="float: left;"/><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a>
   	<img src="<c:url value="/images/store_photo/DSCN0211.JPG"/>" width="410" height="100" style="float: right;" name="banner">
    </h1>
	<p><fmt:message key="webapp.tagline"/></p>		
	    
    </div>
<hr />
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>