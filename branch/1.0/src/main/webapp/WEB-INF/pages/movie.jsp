<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value='/scripts/effects.js'/>"></script>

<head>
<meta name="menu" content="Home" />

<link rel="shortcut icon" href="images/favicon2.ico" />
<link rel="icon" href="images/favicon2.png" type="image/png" />
</head>

<SCRIPT LANGUAGE="JavaScript1.2">

function listImage(list)
{
		var myString = new String(list);

		var path = myString.split("\\s+"); // split on commas

		var images = new Array(); // don't change this

		document.write(path.length+ "<br />");
		
	 	for (i=0; i<=path.length-1; i++)
		{
	 		images[i] = path[i];
			document.write(images[i]+ "<br />");
	 			 		
		}
		return images;
}




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



// Do not edit below this line.



//Presentational Slideshow Script- By Dynamic Drive
//For full source code and more DHTML scripts, visit http://www.dynamicdrive.com
//This credit MUST stay intact for legal use



</SCRIPT>

<div id="main">

	<head>
	<meta name="menu" content="Now Showing" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<c:url value='/styles/${appConfig["csstheme"]}/layout-other.css'/>" />
	</head>
	<div id="movie-list">
		<div class="top">
		<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
				<c:set var="path" value="${path}${catalog.entertainmentService.moviePosterLink}**" />		
			</c:forEach>
		<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
				<c:set var="link" value="${link}${catalog.id}**" />		
		</c:forEach>
		<div style="font-size: 20px;" >
		
		<SCRIPT LANGUAGE="JavaScript1.2">

				//Preload the images path to the rotated images
				var myPath = new String('${path}');

				var path = myPath.split("**"); // split on commas
			
				if (path.length == 1)
						document.write('<fmt:message key="entertainmentService.noMovie"/>');
						
				else
				{ 
				
					var dropimages = new Array();
	
					document.write(path.length + "<br />");
					//document.write(path + "<Br>");
				 	for (i=0; i<path.length-1; i++)
					{
				 		dropimages[i] = path[i];
				 		//document.write(dropimages[i] + "<br />");
				 		 		
					}
	
					//preload the links to the rotated images
					var myLink = new String('${link}');
	
					var link = myLink.split("**");
	
					var droplinks = new Array();
					//document.write(link.length + "<br />");
					//document.write(link + "<br />");
	
					for (i=0; i<link.length-1; i++)
					{
						droplinks[i] = "/moviedetail.html?id=" + link[i];
					}
				
				//document.write(dropimages.length + "<br />");
				
				var slideshow_width='606px' //SET SLIDESHOW WIDTH (set to largest image's width if multiple dimensions exist)
				var slideshow_height='350px' //SET SLIDESHOW HEIGHT (set to largest image's height if multiple dimensions exist)
				var pause
				if (path.length == 2)
					pause=100000
				else
					pause=5000		
				 //SET PAUSE BETWEEN SLIDE (2000=2 seconds)
				var slidebgcolor="white"


					//var droplinks=new Array()
					//SET IMAGE URLs. Use "" if you wish particular image to NOT be linked:
					//droplinks[0]="http://www.yahoo.com"
					//droplinks[1]=""
		
		
					////NO need to edit beyond here/////////////

				var preloadedimages=new Array()
				for (p=0;p<dropimages.length;p++){
				preloadedimages[p]=new Image()
				preloadedimages[p].src=dropimages[p]
				}

					var ie4=document.all
					var dom=document.getElementById

					if (ie4||dom)
					document.write('<div style="position:relative;width:'+slideshow_width+';height:'+slideshow_height+';overflow:hidden"><div id="canvas0" style="position:absolute;width:'+slideshow_width+';height:'+slideshow_height+';background-color:'+slidebgcolor+';left:-'+slideshow_width+'"></div><div id="canvas1" style="position:absolute;width:'+slideshow_width+';height:'+slideshow_height+';background-color:'+slidebgcolor+';left:-'+slideshow_width+'"></div></div>')
					else
					document.write('<a href="javascript:rotatelink()"><img name="defaultslide" src="'+dropimages[0]+'" border=0></a>')

					var curpos=parseInt(slideshow_width)*(-1)
					var degree=10
					var curcanvas="canvas0"
					var curimageindex=linkindex=0
					var nextimageindex=1


					function movepic(){
					if (curpos<0){
					curpos=Math.min(curpos+degree,0)
					tempobj.style.left=curpos+"px"
					}
					else{

					clearInterval(dropslide)
					nextcanvas=(curcanvas=="canvas0")? "canvas0" : "canvas1"
					tempobj=ie4? eval("document.all."+nextcanvas) : document.getElementById(nextcanvas)
					var slideimage='<img src="'+dropimages[curimageindex]+'" border=0>'
					tempobj.innerHTML=(droplinks[curimageindex]!="")? '<a href="'+droplinks[curimageindex]+'">'+slideimage+'</a>' : slideimage
					nextimageindex=(nextimageindex<dropimages.length-1)? nextimageindex+1 : 0
					setTimeout("rotateimage()",pause)
					}
					}

					function rotateimage(){
					if (ie4||dom){
					resetit(curcanvas)
					var crossobj=tempobj=ie4? eval("document.all."+curcanvas) : document.getElementById(curcanvas)
					crossobj.style.zIndex++
					var temp='setInterval("movepic()",20)'
					dropslide=eval(temp)
					curcanvas=(curcanvas=="canvas0")? "canvas1" : "canvas0"
					}
					else
					document.images.defaultslide.src=dropimages[curimageindex]
					linkindex=curimageindex
					curimageindex=(curimageindex<dropimages.length-1)? curimageindex+1 : 0
					}

					function rotatelink(){
					if (droplinks[linkindex]!="")
					window.location=droplinks[linkindex]
					}

					function resetit(what){
					curpos=parseInt(slideshow_width)*(-1)
					var crossobj=ie4? eval("document.all."+what) : document.getElementById(what)
					crossobj.style.left=curpos+"px"
					}

					function startit(){
					var crossobj=ie4? eval("document.all."+curcanvas) : document.getElementById(curcanvas)
					crossobj.innerHTML='<a href="'+droplinks[curimageindex]+'"><img src="'+dropimages[curimageindex]+'" border=0></a>'
					rotateimage()
					}

					if (ie4||dom)
						window.onload=startit
					else
						setInterval("rotateimage()",pause)
				}
					
							 
			
			 </script>
			
			
		
			</div>
		
			<!--  <img src="<c:url value="/images/movie.jpg"/>"  />
			 -->	
		</div>
		<div class="bottom">
			<div class="heading">			
				Movies in	
				<SCRIPT LANGUAGE="JavaScript1.2">
				
				document.write(lmonth + " ");
				document.write(year);

				
				</SCRIPT>
			</div>


				<c:forEach var="catalog" items="${tuxBaseObjectList.list}">
						<a class="list" href="<c:url value="/moviedetail.html?id=${catalog.id}" />" > ${catalog.name}</a>										
				</c:forEach>
									
		</div>
			
		
	</div>
</div>





