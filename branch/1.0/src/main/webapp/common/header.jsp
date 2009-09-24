<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>
<script type="text/javascript"  src="<c:url value="/scripts/ruzee.js" />" ></script> 

<div id="branding">
    <h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
    <p><fmt:message key="webapp.tagline"/></p>
</div>
<hr />
<script language="javascript" type="text/javascript">
    var myBorder = RUZEE.ShadedBorder.create({ corner:8, shadow:16 });
    myBorder.render('branding');
  </script>
<%-- Put constants into request scope --%>
<appfuse:constants scope="request"/>