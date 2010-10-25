<%@ include file="/common/taglibs.jsp"%>

<!-- ONE STEP TO INSTALL CURRENT DATE:

   1.  Put the code into the BODY of your HTML document  -->

<!-- STEP ONE: Copy this code into the BODY of your HTML document  -->


<SCRIPT LANGUAGE="JavaScript1.2">



var months=new Array(13);
months[1]="January";
months[2]="February";
months[3]="March";
months[4]="April";
months[5]="May";
months[6]="June";
months[7]="July";
months[8]="August";
months[9]="September";
months[10]="October";
months[11]="November";
months[12]="December";
var time=new Date();
var lmonth=months[time.getMonth() + 1];
var date=time.getDate();
var year=time.getYear();
if (year < 2000)
year = year + 1900;

// End -->
</SCRIPT>

<div id="main">

	<head>
	<meta name="menu" content="Now Showing" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	<div id="movie-list">
		<div class="top">
			<img src="<c:url value="/images/movie.jpg"/>"  />
				
		</div>
		<div class="bottom">
			<div class="heading">
			
				Movie in
				<SCRIPT LANGUAGE="JavaScript1.2">
				
				document.write(lmonth + " ");
				document.write(year);
				</SCRIPT>
				
			</div>
					
				<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
								<div class="list">
				
						<a "href="<c:url value="/moviedetail.html?id=${catalog.id}" />" > ${catalog.name}</a>
										</div>
					
				</c:forEach>

		</div>
			
		
	</div>
</div>








