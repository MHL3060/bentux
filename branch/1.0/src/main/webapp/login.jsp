<%@ include file="/common/taglibs.jsp"%>

<style>
    a {background-color:inherit; color:white; font-weight:700; text-decoration:none;}
	a:hover {background-color:inherit; color:white;}

</style>
<head>
    <title><fmt:message key="login.title"/></title>
        <meta name="menu" content="Login"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
</head>
<body id="login"/>
<div id="login">
	
	<div class="title">
		<div class="h1"><fmt:message key="login.welcome" /></div>
		<div class="h3"><fmt:message key="login.welcome2" /></div>
	</div>
	<div class="left-bar">
	 <div class="h4"><fmt:message key="login.member.login"/></div>
		<div class="login-form">
		
		<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
			    onsubmit="saveUsername(this);return validateForm(this)">
		<ul>
		  <li>
		       <label for="j_username" class="required desc">
		            <fmt:message key="label.username"/> <span class="req">*</span>
		        </label>
		        <input type="text" class="text medium" name="j_username" id="j_username" tabindex="1" />
		    </li>

		    <li>
		        <label for="j_password" class="required desc">
		            <fmt:message key="label.password"/> <span class="req">*</span>
		        </label>
		        <input type="password" class="text medium" name="j_password" id="j_password" tabindex="2" />
		    </li>
		
		<c:if test="${appConfig['rememberMeEnabled']}">
		    <li>
		        <input type="checkbox" class="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
		        <label for="rememberMe" class="choice"><fmt:message key="login.rememberMe"/></label>
		    </li>
		</c:if>
			<p>
		   <li>
                  <input type="submit" class="button" name="login" value="<fmt:message key='button.login'/>" tabindex="4" />
                    </li>
            </p>
                </ul>
                	<p><fmt:message key="login.passwordHint"/></p>
                
                </form>
                
                
        </div>
       </div>
       <div class="right-bar">
        <div class="register-form">
                <div class="h4"><fmt:message key="login.register.title"/></div>
                
           	   <div class="wording"><fmt:message key="login.register1"/> </div>
               <div class="wording"> <fmt:message key="login.register2"/> </div>
               <div class="button2"><fmt:message key="button.register2">
                						<fmt:param><c:url value="/signup.html"/></fmt:param>
            						</fmt:message>
         	  </div>
         	</div>
        </div>

        <%@ include file="/scripts/login.js"%>
		
</div>
	 <c:if test="${param.error != null}">
	    <div class="error">
	        <img src="${ctx}/images/iconWarning.gif" alt="<fmt:message key='icon.warning'/>" class="icon"/>
	        <fmt:message key="errors.password.mismatch"/>
	        <%--${sessionScope.SPRING_SECURITY_LAST_EXCEPTION_KEY.message}--%>
	    </div>
	</c:if>