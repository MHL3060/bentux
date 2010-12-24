<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/styles/${appConfig["csstheme"]}/popup.css'/>" />
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/styles/${appConfig["csstheme"]}/lightwindow.css'/>" />
        <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/styles/lightbox.css'/>"  />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/styles/${appConfig["csstheme"]}/print.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/layout-home.css'/>" />
       
        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        
        <script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <script type="text/javascript"  src="<c:url value="/scripts/ruzee.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor_basic.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/scripts/lightbox.js" />"></script>
        <decorator:head/>
    </head>

 <% 
 	String myURI = request.getRequestURI();	
	if (myURI.contains("/login")){
		request.setAttribute("isLoginPage", Boolean.TRUE);
	}else {
		request.setAttribute("isLoginPage", Boolean.FALSE);
	}
%>   
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div id="page">
        <div id="header" class="clearfix">
            <jsp:include page="/common/header.jsp"/>
        </div>

        <div id="content" class="clearfix">
			 <c:if test="${isLoginPage == false}">
				
				 <div id="nav">
	                <div class="wrapper">
	                    <h2 class="accessibility">Navigation</h2>
	                    <jsp:include page="/common/menu.jsp"/>
	                </div>
	                <hr/>
	    		</div>
	    	</c:if>
	        <div id="main">
                <%@ include file="/common/messages.jsp" %>
                <h1><decorator:getProperty property="meta.heading"/></h1>
                <decorator:body/>
            </div>
           <!-- <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>-->
           <!-- =<c:if test="${currentMenu == 'AdminMenu'}">
               <menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
                        <menu:displayMenu name="AdminMenu"/>
                 </menu:useMenuDisplayer>
			</c:if>
			-->
			<c:if test="${isLoginPage == false}">
			
	            <div id="sub" class="clearfix">
	                <%@ include file="/common/sub.jsp" %>
	           
	            </div>
			</c:if>

 
         
         </div><!-- end nav -->
			
		
        <div id="footer" class="clearfix">
            <jsp:include page="/common/footer.jsp"/>
        </div>
   	</div>
</body>
</html>
